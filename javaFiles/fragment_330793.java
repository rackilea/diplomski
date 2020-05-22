import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class StringUtils {

  static CharsetEncoder asciiEncoder = 
      Charset.forName("US-ASCII").newEncoder(); // or "ISO-8859-1" for ISO Latin 1

  public static boolean isPureAscii(String v) {
    return asciiEncoder.canEncode(v);
  }

  public static void main (String args[])
    throws Exception {

     String test = " برام ";
     System.out.println(test + " isPureAscii() : " + StringUtils.isPureAscii(test));
     test = "Real";
     System.out.println(test + " isPureAscii() : " + StringUtils.isPureAscii(test));

     /*
      * output :
      *    برام isPureAscii() : false
      *   Real isPureAscii() : true
      */
  }
}