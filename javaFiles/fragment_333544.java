private static final char[] CHARS = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

private static String convertIntToBase(int i, int base){
    final StringBuilder builder = new StringBuilder();
    do{
        builder.append(CHARS[i % base]);
        i /= base;
    } while(i > 0);
    return builder.reverse().toString();
}