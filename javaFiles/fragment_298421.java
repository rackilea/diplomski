public class Main {
  public static void main(String[] args) {
    CryptographerContext cryptographer = new CryptographerContext();
    cryptographer.setEncryptionStrategy(new UnicodeEncryptionAlgorithm());
    String encText = cryptographer.getEncryptedContents("some text");
    System.out.println("Encrypted text: "+encText);
  }
}