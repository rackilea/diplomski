import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.text.translate.UnicodeUnescaper;

void convert() {
    String incoming = "<html> <head></head> <body>  <p><span style=\"font-family: Arial;\">Ευχαριστώ (eff-kha-ri-STOE) Tι κανείς (tee-KAH-nis)? Mε συγχωρείτε.</span></p> </body></html>";
    String escaped = StringEscapeUtils.escapeJava(incoming); 
    String greekChars = new UnicodeUnescaper().translate(escaped);

    System.out.println("incoming:   " + incoming); 
    System.out.println("escaped:    " + escaped);    // Quotes are escaped, and Greek characters are converted to Unicode escapes.
    System.out.println("greekChars: " + greekChars); // Quotes remain escaped, but Unicode escapes are converted back to Greek characters.
}