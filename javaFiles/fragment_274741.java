public class DecryptionResult {
    String decryptedValue;
    String key1;
    String key2;

    public DecryptionValue(String decryptedValue, String key1, String key2) {
        this.decryptedValue = decryptedValue;
        this.key1 = key1;
        this.key2 = key2;
    }

    public String getDecryptedValue() {
        return decryptedValue;
    }

    public String getKey1() {
        return key1;
    }

    public String getKey2() {
        return key2;
    }
}