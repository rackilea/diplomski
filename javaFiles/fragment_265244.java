// imports from java.* and javax.crypto.*
public abstract class ReloadableProperties {

  private volatile Properties properties = null;
  private volatile String propertiesPassword = null;
  private volatile long lastModTimeOfFile = 0L;
  private volatile long lastTimeChecked = 0L;
  private volatile Path propertyFileAddress;

  abstract protected void propertiesUpdated();

  public class DynProp {
    private final String propertyName;
    public DynProp(String propertyName) {
      this.propertyName = propertyName;
    }
    public String val() {
      try {
        return ReloadableProperties.this.getString(propertyName);
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
  }

  protected void init(Path path) {
    this.propertyFileAddress = path;
    initOrReloadIfNeeded();
  }

  private synchronized void initOrReloadIfNeeded() {
    boolean firstTime = lastModTimeOfFile == 0L;
    long currentTs = System.currentTimeMillis();

    if ((lastTimeChecked + 3000) > currentTs)
      return;

    try {

      File fa = propertyFileAddress.toFile();
      long currModTime = fa.lastModified();
      if (currModTime > lastModTimeOfFile) {
        lastModTimeOfFile = currModTime;
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fa), StandardCharsets.UTF_8);
        Properties prop = new Properties();
        prop.load(isr);
        properties = prop;
        isr.close();
        File passwordFiles = new File(fa.getAbsolutePath() + ".key");
        if (passwordFiles.exists()) {
          byte[] bytes = Files.readAllBytes(passwordFiles.toPath());
          propertiesPassword = new String(bytes,StandardCharsets.US_ASCII);
          propertiesPassword = propertiesPassword.trim();
          propertiesPassword = propertiesPassword.replaceAll("(\\r|\\n)", "");
        }
      }

      updateProperties();

      if (!firstTime)
        propertiesUpdated();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void updateProperties() {
    List<DynProp> dynProps = Arrays.asList(this.getClass().getDeclaredFields())
        .stream()
        .filter(f -> f.getType().isAssignableFrom(DynProp.class))
        .map(f-> fromField(f))
        .collect(Collectors.toList());

    for (DynProp dp :dynProps) {
      if (!properties.containsKey(dp.propertyName)) {
        System.out.println("propertyName: "+ dp.propertyName + " does not exist in property file");
      }
    }

    for (Object key : properties.keySet()) {
      if (!dynProps.stream().anyMatch(dp->dp.propertyName.equals(key.toString()))) {
        System.out.println("property in file is not used in application: "+ key);
      }
    }

  }

  private DynProp fromField(Field f) {
    try {
      return (DynProp) f.get(this);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  protected String getString(String param) throws Exception {
    initOrReloadIfNeeded();
    String value = properties.getProperty(param);
    if (value.startsWith("ENC(")) {
      String cipheredText = value
          .replace("ENC(", "")
          .replaceAll("\\)$", "");
      value =  decrypt(cipheredText, propertiesPassword);
    }
    return value;
  }

  public static String encrypt(String plainText, String key)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
    SecureRandom secureRandom = new SecureRandom();
    byte[] keyBytes = key.getBytes(StandardCharsets.US_ASCII);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec spec = new PBEKeySpec(key.toCharArray(), new byte[]{0,1,2,3,4,5,6,7}, 65536, 128);
    SecretKey tmp = factory.generateSecret(spec);
    SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
    byte[] iv = new byte[12];
    secureRandom.nextBytes(iv);
    final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv); //128 bit auth tag length
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
    byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    ByteBuffer byteBuffer = ByteBuffer.allocate(4 + iv.length + cipherText.length);
    byteBuffer.putInt(iv.length);
    byteBuffer.put(iv);
    byteBuffer.put(cipherText);
    byte[] cipherMessage = byteBuffer.array();
    String cyphertext = Base64.getEncoder().encodeToString(cipherMessage);
    return cyphertext;
  }
  public static String decrypt(String cypherText, String key)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
    byte[] cipherMessage = Base64.getDecoder().decode(cypherText);
    ByteBuffer byteBuffer = ByteBuffer.wrap(cipherMessage);
    int ivLength = byteBuffer.getInt();
    if(ivLength < 12 || ivLength >= 16) { // check input parameter
      throw new IllegalArgumentException("invalid iv length");
    }
    byte[] iv = new byte[ivLength];
    byteBuffer.get(iv);
    byte[] cipherText = new byte[byteBuffer.remaining()];
    byteBuffer.get(cipherText);
    byte[] keyBytes = key.getBytes(StandardCharsets.US_ASCII);
    final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec spec = new PBEKeySpec(key.toCharArray(), new byte[]{0,1,2,3,4,5,6,7}, 65536, 128);
    SecretKey tmp = factory.generateSecret(spec);
    SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
    cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));
    byte[] plainText= cipher.doFinal(cipherText);
    String plain = new String(plainText, StandardCharsets.UTF_8);
    return plain;
  }
}