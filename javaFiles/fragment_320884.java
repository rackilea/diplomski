/**
 * Used to test the cipher class
 */
public class CipherTest
{
    public static void main(String[] args)
    {
        Cipher hello = new Cipher("hello");
        System.out.println(hello.getText() + hello.getMatrix() + hello.getEncodedMatrix());
    }
}