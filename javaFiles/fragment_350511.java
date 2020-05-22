String fileName = "secretkey.ks";
char[] password = "mypassword".toCharArray();
String alias = "secret1";

KeyStore ks = KeyStore.getInstance("JCEKS");
try (FileInputStream fis = new FileInputStream(fileName)) {
    ks.load(fis, password);
    SecretKey secretKey = (SecretKey) ks.getKey(alias, password);
    System.out.println(new BigInteger(1, secretKey.getEncoded()).toString(16));
}