package test;

import java.io.UnsupportedEncodingException;

public class TrimField {

    public static void main(String[] args) {
        //UTF-8 is the db charset
        System.out.println(trim("Rückruf ins Ausland",10,"UTF-8"));
        System.out.println(trim("Rüückruf ins Ausland",10,"UTF-8"));
    }

    public static String trim(String value, int numBytes, String charset) {
        do {
            byte[] valueInBytes = null;
            try {
                valueInBytes = value.getBytes(charset);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            if (valueInBytes.length > numBytes) {
                value = value.substring(0, value.length() - 1);
            } else {
                return value;
            }
        } while (value.length() > 0);
        return "";

    }

}