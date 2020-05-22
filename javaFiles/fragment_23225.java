public class UseTheForce {
    public static void main(final String[] args)
        throws java.io.UnsupportedEncodingException {
        for (final byte b : args[0].getBytes(args[1])) {
            System.out.printf("%1$02X ", (b & 0xFF));
        }
        System.out.println();
    }
}