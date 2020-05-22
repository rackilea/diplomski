import org.apache.pdfbox.io.ASCII85InputStream;
 import org.apache.pdfbox.io.ASCII85OutputStream;

 import java.io.ByteArrayInputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.UnsupportedEncodingException;
 import java.util.ArrayList;



 public class Ascii85Coder {

 public static byte[] decodeAscii85StringToBytes(String ascii85) {
    ArrayList<Byte> list = new ArrayList<Byte>();
    ByteArrayInputStream in_byte = null;
    try {
        in_byte = new ByteArrayInputStream(ascii85.getBytes("ascii"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    ASCII85InputStream in_ascii = new ASCII85InputStream(in_byte);
    try {
        int r ;
        while ((r = in_ascii.read()) != -1) {
            list.add((byte) r);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    byte[] bytes = new byte[list.size()];
    for (int i = 0; i < bytes.length; i++) {
        bytes[i] = list.get(i);
    }
    return bytes;
}


public static String encodeBytesToAscii85(byte[] bytes) {
    ByteArrayOutputStream out_byte = new ByteArrayOutputStream();
    ASCII85OutputStream  out_ascii = new ASCII85OutputStream(out_byte);

    try {
        out_ascii.write(bytes);
        out_ascii.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
    String res = "";
    try {
        res = out_byte.toString("ascii");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return res;
}
}