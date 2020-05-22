private static final String TAB_00C0 = "" +
        "AAAAAAACEEEEIIII" +
        "DNOOOOO×OUUUÜYTs" + // <-- note an accented letter you wanted 
                             //     and preserved multiplication sign
        "aaaaaaaceeeeiiii" +
        "dnooooo÷ouuuüyty" + // <-- note an accented letter and preserved division sign
        "AaAaAaCcCcCcCcDd" +
        "DdEeEeEeEeEeGgGg" +
        "GgGgHhHhIiIiIiIi" +
        "IiJjJjKkkLlLlLlL" +
        "lLlNnNnNnnNnOoOo" +
        "OoOoRrRrRrSsSsSs" +
        "SsTtTtTtUuUuUuUu" +
        "UuUuWwYyYZzZzZzs";

public static String toPlain(String source) {
    StringBuilder sb = new StringBuilder(source.length());
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch (c) {
            case 'ß':
                sb.append("ss");
                break;
            case 'Œ':
                sb.append("OE");
                break;
            case 'œ':
                sb.append("oe");
                break;
            // insert more ligatures you want to support 
            // or other letters you want to convert in a non-standard way here
            // I recommend to take a look at: æ þ ð ﬂ ﬁ
            default:
                if (c >= 0xc0 && c <= 0x17f) {
                    c = TAB_00C0.charAt(c - 0xc0);
                }
                sb.append(c);
        }
    }
    return sb.toString();
}