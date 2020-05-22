import java.io.*;
import java.util.*;

public class TextConverter {

    public static void main(String[] args) {
        if (args.length == 1) {
            String language = args[0];

            List<String> text = new Vector<String>();

            try {
                // read text from Notepad UTF-8 file
                InputStream in = new FileInputStream(language + ".utf8");
                try {
                    BufferedReader bufin = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    String s;
                    while ( (s = bufin.readLine()) != null ) {
                        // remove formatting character added by Notepad
                        s = s.replaceAll("\ufffe", "");
                        text.add(s);
                    }
                } finally {
                    in.close();
                }

                // write it for easy reading in J2ME
                OutputStream out = new FileOutputStream(language + ".res");
                DataOutputStream dout = new DataOutputStream(out);
                try {
                    // first item is the number of strings
                    dout.writeShort(text.size());
                    // then the string themselves
                    for (String s: text) {
                        dout.writeUTF(s);
                    }
                } finally {
                    dout.close();
                }
            } catch (Exception e) {
                System.err.println("TextConverter: " + e);
            }
        } else {
            System.err.println("syntax: TextConverter <language-code>");
        }
    }
}