import java.util.*;
import java.lang.*;

class Main
{
        public static void main (String[] args) throws java.lang.Exception
        {
                String s = new String("123456789");
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                crc32.update(s.getBytes());
                System.out.println(crc32.getValue());
        }
}