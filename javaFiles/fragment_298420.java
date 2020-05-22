public class CryptographerContext {

    private EncryptionAlgorithm encAlgo;

    public void setEncryptionStrategy(EncryptionAlgorithm encAlgo) {
        this.encAlgo = encAlgo;
    }

    public String getEncryptedContents(String text) {
        return encAlgo.encrypt(text);
    }
}