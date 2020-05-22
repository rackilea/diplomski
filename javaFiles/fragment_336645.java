public class Converter {
public static void main(String[] args) {
    String hex = "48985DDFAF27A0";
    long longHex = parseUnsignedHex(hex);
    double d =   Double.longBitsToDouble(longHex);
    System.out.println(d);
 }

public static long parseUnsignedHex(String text) {
    if (text.length() == 16) {
        return  (parseUnsignedHex(text.substring(0, 1)) << 60)
                | parseUnsignedHex(text.substring(1));
    }
    return Long.parseLong(text, 16);
}
}