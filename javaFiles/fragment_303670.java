private BigInteger n = new BigInteger("187");
  private BigInteger e = new BigInteger("3");
  private BigInteger d = new BigInteger("107");

  public static void main(String[] args) {
    KeyTest test = new KeyTest();

    BigInteger plaintext = new BigInteger("55");
    System.out.println("Plain text: " + plaintext);

    BigInteger ciphertext = test.encrypt(plaintext);
    System.out.println("Ciphertext: " + ciphertext);

    BigInteger decrypted = test.decrypt(ciphertext);
    System.out.println("Plain text after decryption: " + decrypted);
  }

  public BigInteger encrypt(BigInteger plaintext) {

    return plaintext.modPow(e, n);
  }

  public BigInteger decrypt(BigInteger ciphertext) {

    return ciphertext.modPow(d, n);
  }
}