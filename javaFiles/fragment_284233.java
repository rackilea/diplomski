public static String cobolName2JavaName(String cobolName) {
    String lcCobolName = cobolName.toLowerCase();
    String ucCobolName = cobolName.toUpperCase();
    int length = cobolName.length();
    StringBuilder b = new StringBuilder(length);

    boolean toUCase = true; 
    char c;

    for (int i = 0; i < length; i++) {
        c = lcCobolName.charAt(i);
        switch (c) {
        case '-':
        case '_':
            toUCase = true;
            b.append(c)
            break;
        default:
            if (toUCase) {
                b.append(ucCobolName.charAt(i));
                toUCase = false;
            } else {
                b.append(c);
            }
        }
    }
    return b.toString();
}