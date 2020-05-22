import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
    URL googleUrl = new URL("http://www.google.com/transliterate/arabic?tlqt=1&langpair=en|ar&text=ana,m­asry&&tl_app=1");
    URLConnection googleUrlc = googleUrl.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(googleUrlc.getInputStream()));
    String inputLine;
    Pattern wordRegex = Pattern.compile("\"(\\\\u[\\da-z]{4})+\"", Pattern.CASE_INSENSITIVE);
    Pattern charRegex = Pattern.compile("\\\\u([\\da-z]{4})", Pattern.CASE_INSENSITIVE);
    while ((inputLine = in.readLine()) != null) {
        Matcher wordMatch = wordRegex.matcher(inputLine);
        for (int i = 0; wordMatch.find(); i++) {
        StringBuffer arabicBuffer = new StringBuffer();
        Matcher charMatch = charRegex.matcher(wordMatch.group());
        for (int j = 0; charMatch.find(); j++) {
            arabicBuffer.appendCodePoint(Integer.valueOf(charMatch.group(1), 16));
        }
        if (0 < arabicBuffer.length()) {
            System.out.println(arabicBuffer.toString());
        }       
        } 
    }
    in.close(); 
    }
}