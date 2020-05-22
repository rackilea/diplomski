import java.util.regex.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RegexFloat {
    public static void main(String args[]) {
        String testString = "foo 3.14E+2xx";
        AtomicInteger parsePos = new AtomicInteger(0);
        Double d = parseDouble(testString, parsePos);
        System.out.println(d);
        System.out.println(parsePos);
    }

    static Double parseDouble(String str, AtomicInteger parsePos) {
        Pattern pattern = Pattern.compile(fpRegex);
        Matcher m = pattern.matcher(str.substring(parsePos.get()));

        if (m.find()) {
            parsePos.set(m.end(1));
            return Double.parseDouble(m.group(1));
        }
        return null;
    }

    // or Pattern.compile(String.format(".{%d}%s", parsePos.get(), fpRegex));
    // if you want to avoid substring above for some reason and
    // want to add offset into the pattern


    static final String Digits     = "(\\p{Digit}+)";
    static final String HexDigits  = "(\\p{XDigit}+)";
    // an exponent is 'e' or 'E' followed by an optionally
    // signed decimal integer.
    static final String Exp        = "[eE][+-]?"+Digits;
    static final String fpRegex    =
      ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
       "[+-]?(" + // Optional sign character
       "NaN|" +           // "NaN" string
       "Infinity|" +      // "Infinity" string

       // A decimal floating-point string representing a finite positive
       // number without a leading sign has at most five basic pieces:
       // Digits . Digits ExponentPart FloatTypeSuffix
       //
       // Since this method allows integer-only strings as input
       // in addition to strings of floating-point literals, the
       // two sub-patterns below are simplifications of the grammar
       // productions from section 3.10.2 of
       // The Java™ Language Specification.

       // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
       "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

       // . Digits ExponentPart_opt FloatTypeSuffix_opt
       "(\\.("+Digits+")("+Exp+")?)|"+

       // Hexadecimal strings
       "((" +
        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
        "(0[xX]" + HexDigits + "(\\.)?)|" +

        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

        ")[pP][+-]?" + Digits + "))" +
       "[fFdD]?))" +
       "[\\x00-\\x20]*");// Optional trailing "whitespace"    
}