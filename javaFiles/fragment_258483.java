public class ToyCiphertextCodec {
    private ToyCiphertextCodec() {
        // nothin' to do here
    }

    public static ToyCiphertextCodec getInstance() {
        return new ToyCiphertextCodec();
    }

    public String encode(int[] ciphertext) {
        // this is relatively lazy, probably better off creating the
        // encoding yourself if you are using this "in the field"
        return Arrays.toString(ciphertext);
    }

    public int[] decode(String encodedCiphertext) {
        if (!encodedCiphertext.startsWith("[") || !encodedCiphertext.endsWith("]")) {
            throw new IllegalArgumentException("Ciphertext encoding invalid");
        }
        String encodedCiphertextWithoutBrackets = encodedCiphertext.substring(1, encodedCiphertext.length() - 1);
        String[] numbers = encodedCiphertextWithoutBrackets.split(", ");
        int[] intermediateResult = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intermediateResult[i] = Integer.parseInt(numbers[i]);
        }
        return intermediateResult;
    }

    public static void main(String[] args) {
        ToyCiphertextCodec t = ToyCiphertextCodec.getInstance();

        int[] ciphertext = { 1, 2, 3 };
        String encodedCiphertext = t.encode(ciphertext);
        System.out.println(encodedCiphertext);

        int[] decodedCiphertext = t.decode(encodedCiphertext);
        System.out.println(Arrays.equals(ciphertext, decodedCiphertext));
    }
}