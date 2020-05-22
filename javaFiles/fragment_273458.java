private static final String ALGORITHM = "SHA1PRNG";
private static final String PROVIDER = "SUN";

private SecureRandom getSecureRandom(String seed) throws NoSuchAlgorithmException, NoSuchProviderException {
  SecureRandom sr = SecureRandom.getInstance(ALGORITHM, PROVIDER);
  sr.setSeed(seed.getBytes(UTF8_CHARSET));
  return sr;
}