import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;
public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

        byte[] out = toByteArray("0000005401F40000D9E3C60500000000002000000000000000D7C8F10000000000000000000000004040404040404040D9E3C600E9C7C9F0F0F0F1F1E5D9C1D1C1D54040F0F0F14BF0F0F14BF0F0F14BF0F0F100"); // Input Hex String
        System.out.println("ASCII: " + Arrays.toString(out)); 
        String hex = toHexString(out);
        System.out.println("Hex: " + hex); // Prints the hex - 00000054 exactly


    }
    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

}