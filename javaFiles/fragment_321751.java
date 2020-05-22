import java.awt.Point;
import java.io.*;

class Test {

    public static byte[] getBytes(Object object) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
        objectStream.writeObject(object);
        objectStream.close();
        return byteStream.toByteArray(); 
    }

    public static void main(String[] args) throws IOException {

        byte[] iBytes = getBytes(new Integer(123123));
        System.out.println(new String(iBytes,  8, 17)); // "java.lang.Integer"
        System.out.println(new String(iBytes, 39,  5)); // "value"
        System.out.println(new String(iBytes, 48, 16)); // "java.lang.Number"
        // ...

        byte[] pBytes = getBytes(new Point(123, 123));
        System.out.println(new String(pBytes, 8, 14));  // "java.awt.Point"
        // ...
    }
}