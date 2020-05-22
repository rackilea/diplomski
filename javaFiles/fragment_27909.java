package sample;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class UnicodeSample {
    public static final int HEXADECIMAL = 16;

    public static void main(String[] args) {

        try {
            String str = "\\u0068\\u0065\\u006c\\u006c\\u006f\\u000a\\u3fff\\uf34c";

            ArrayList<Byte> arrList = new ArrayList<Byte>();
            String codes[] = str.replaceAll("\\\\u"," ").trim().split(" ");

            for (String c : codes) {

                int code = Integer.parseInt(c,HEXADECIMAL);
                byte[] bytes = intToByteArray(code);

                for (byte b : bytes) {
                    if (b != 0) arrList.add(b);
                }
            }

            byte[] utf8 = new byte[arrList.size()];
            for (int i=0; i<arrList.size(); i++) utf8[i] = arrList.get(i);

            str = new String(utf8, "UTF-8");
            System.out.println(str);
        }
        catch (UnsupportedEncodingException e) {
            // handle the exception when
        }
    }

    // Takes a 4 byte integer and and extracts each byte
    public static final byte[] intToByteArray(int value) {
        return new byte[] {
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) (value)
        };
    }
}