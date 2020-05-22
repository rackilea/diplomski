import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;

class Example {

    private static final int VALUES_RADIX = 16;
    private static final String FIRST_VALUE = "a12104c6134e57914f104f2521ba4422c4d7b184f4815541f80484e1e24161d64d54ba2210194510164d4f3a0534304e43e1e1da524612171b11701be45431cc1d16a52d11744e1961a114de55174f84e54371";
    private static final String SECOND_VALUE = "32510ba9babebbbefd001547a810e67149caee11d945cd7fc81a05e9f85aac650e9052ba6a8cd8257bf14d13e6f0a803b54fde9e77472dbff89d71b57bddef121336cb85ccb8f3315f4b52e301d16e9f52f904";

    public static void main(String[] args) {
        BigInteger firstValueToXor = new BigInteger(FIRST_VALUE, VALUES_RADIX);
        BigInteger secondValueToXor = new BigInteger(SECOND_VALUE, VALUES_RADIX);
        BigInteger result = firstValueToXor.xor(secondValueToXor);
        String stringResultRepresentation = result.toString(VALUES_RADIX);
        System.out.println(stringResultRepresentation);

        try {
            byte[] asciiResultRepresentation = stringResultRepresentation.getBytes("US-ASCII");
            System.out.println(Arrays.toString(asciiResultRepresentation));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}