import se.welcomweb.utils.zbase32j;

public class TestZBase32J {

    public static void main(String ... args) {

        ZBase32j zbase = new ZBase32j();

        String message = "Hello, world!";
        String encoded = zbase.encode(message);
        System.out.println("Encoded: " + encoded);

        String decoded = zbase.decode(encoded);
        System.out.println("Decoded: " + decoded);

    }

}