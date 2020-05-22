import java.util.*;
import java.nio.ByteBuffer;


public class Main{ 
    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(2151);
        byte[] result = b.array();
        for (int i = 0; i < 4; i++)
            System.out.printf("%x\n", result[i]);
    }
}