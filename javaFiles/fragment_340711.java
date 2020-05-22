import java.security.NoSuchAlgorithmException;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

public class JacksumTest {
    public static void main(String arg[])
    {
        String password = "somepwd";
        AbstractChecksum checksum = null; 
        try { 
           checksum = JacksumAPI.getChecksumInstance("whirlpool"); 
           checksum.update(password.getBytes());
           System.out.println(checksum.getFormattedValue());
        } catch (NoSuchAlgorithmException nsae) { }
    }
}