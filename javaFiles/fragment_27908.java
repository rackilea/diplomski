package sample;

import java.io.UnsupportedEncodingException;

public class UnicodeSample {
    public static final int HEXADECIMAL = 16;

    public static void main(String[] args) {

        try {
            String str = "\\u0068\\u0065\\u006c\\u006c\\u006f\\u000a";

            String arr[] = str.replaceAll("\\\\u"," ").trim().split(" ");
            byte[] utf8 = new byte[arr.length];

            int index=0;
            for (String ch : arr) {
                utf8[index++] = (byte)Integer.parseInt(ch,HEXADECIMAL);
            }

            String newStr = new String(utf8, "UTF-8");
            System.out.println(newStr);

        }
        catch (UnsupportedEncodingException e) {
            // handle the UTF-8 conversion exception
        }
    }
}