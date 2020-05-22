import org.apache.commons.codec.binary.Base64;

public class GiveMeANameHere {

    public static void main(String[] args) {
        Base64 decoder = new Base64();
        byte[] license = decoder.decode(args[0]);

        // Do whatever you need to with the license.
        // Other strings passed in will appear as elements in args array
    }
}