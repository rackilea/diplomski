public class NumericRangeRegexGenerator {

    private static String baseRange(String num, boolean up, boolean leading1) {

        char c = num.charAt(0);
        char low  = up ? c : leading1 ? '1' : '0';
        char high = up ? '9' : c;

        if (num.length() == 1)
            return charClass(low, high);

        String re = c + "(" + baseRange(num.substring(1), up, false) + ")";

        if (up) low++; else high--;

        if (low <= high)
            re += "|" + charClass(low, high) + nDigits(num.length() - 1);

        return re;
    }

    private static String charClass(char b, char e) {
        return String.format(b==e ? "%c" : e-b>1 ? "[%c-%c]" : "[%c%c]", b, e);
    }

    private static String nDigits(int n) {
        return nDigits(n, n);
    }

    private static String nDigits(int n, int m) {
        return "[0-9]" + String.format(n==m ? n==1 ? "":"{%d}":"{%d,%d}", n, m);
    }

    private static String eqLengths(String from, String to) {

        char fc = from.charAt(0), tc = to.charAt(0);

        if (from.length() == 1 && to.length() == 1)
            return charClass(fc, tc);

        if (fc == tc)
            return fc + "("+rangeRegex(from.substring(1), to.substring(1))+")";

        String re = fc + "(" + baseRange(from.substring(1), true, false) + ")|"
                  + tc + "(" + baseRange(to.substring(1),  false, false) + ")";

        if (++fc <= --tc)
            re += "|" + charClass(fc, tc) + nDigits(from.length() - 1);

        return re;
    }    

    private static String nonEqLengths(String from, String to) {
        String re = baseRange(from,true,false) + "|" + baseRange(to,false,true);
        if (to.length() - from.length() > 1)
            re += "|[1-9]" + nDigits(from.length(), to.length() - 2);
        return re;
    }

    public static String rangeRegex(int n, int m) {
        return rangeRegex("" + n, "" + m);
    }

    public static String rangeRegex(String n, String m) {
        return n.length() == m.length() ? eqLengths(n, m) : nonEqLengths(n, m);
    }

}