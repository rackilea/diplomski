import java.io.UnsupportedEncodingException;

public class TestBin {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] infoBin = null;
        infoBin = "this is plain text".getBytes("UTF-8");
        for (byte b : infoBin) {
            System.out.println("c:" + (char) b + "-> "
                    + Integer.toBinaryString(b));
        }
    }
}