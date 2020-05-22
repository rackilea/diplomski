import java.util.*;
import java.nio.ByteBuffer;


public class Main{ 

    public static byte[] getBytes(int input) {
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(input);
        return b.array();
    }
    public static void main(String[] args) {
        int methodname = 5;
        int payload  = 2151;

        byte[] payloadBytes = getBytes(payload);
        int payloadlength = 2; // We always assume this is 2.

        byte[] result = new byte[5];
        result[0] = (byte) (methodname);

        // The following two lines are the same always.
        result[1] = 0; 
        result[2] = (byte) (payloadlength);

        // Here we put in the payload, ignoring the first two Most Significant Bytes
        result[3] = payloadBytes[2];
        result[4] =  payloadBytes[3];
        for (int i = 0; i < 5; i++)
            System.out.printf("%x\n", result[i]);
    }
}