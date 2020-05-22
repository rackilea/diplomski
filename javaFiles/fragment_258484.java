import java.util.Arrays;

public class ToyCiphertextCodecWithModulus {
    private final int sizeOfNumbers;
    private final String staticallySizedNumberFormat;

    private ToyCiphertextCodecWithModulus(int sizeOfNumbers) {
        this.sizeOfNumbers = sizeOfNumbers;
        this.staticallySizedNumberFormat = "%0" + sizeOfNumbers + "d";
    }

    public static ToyCiphertextCodecWithModulus getInstanceForModulus(int n) {
        int largestNumberOfDigits = String.valueOf(n - 1).length();
        return new ToyCiphertextCodecWithModulus(largestNumberOfDigits);
    }

    public String encode(int[] ciphertext) {
        StringBuilder sb = new StringBuilder(ciphertext.length * sizeOfNumbers);
        for (int i = 0; i < ciphertext.length; i++) {
            sb.append(String.format(staticallySizedNumberFormat, ciphertext[i]));
        }
        return sb.toString();
    }

    public int[] decode(String encodedCiphertext) {
        if (encodedCiphertext.length() % sizeOfNumbers != 0) {
            throw new IllegalArgumentException("Ciphertext encoding invalid");
        }

        int numbers = encodedCiphertext.length() / sizeOfNumbers;
        int[] intermediateResult = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            String number = encodedCiphertext.substring(i * sizeOfNumbers, (i + 1) * sizeOfNumbers);
            intermediateResult[i] = Integer.parseInt(number);
        }
        return intermediateResult;
    }

    public static void main(String[] args) {
        ToyCiphertextCodecWithModulus t = ToyCiphertextCodecWithModulus.getInstanceForModulus(997);

        int[] ciphertext = { 1, 2, 3 };
        String encodedCiphertext = t.encode(ciphertext);
        System.out.println(encodedCiphertext);

        int[] decodedCiphertext = t.decode(encodedCiphertext);
        System.out.println(Arrays.equals(ciphertext, decodedCiphertext));
    }
}