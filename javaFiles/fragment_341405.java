public static String makeTimestamp() {
    return formatTime(System.currentTimeMillis(), 7);
}

public static String formatTime(long millis, int fractionDigits) {
    int integerDigits = (int) Math.log10(millis / 1000.0) + 1;

    char[] chars = new char[integerDigits + fractionDigits + 1];
    for (int i = 0; i < chars.length; i++) {
        chars[i] = '0';
    }

    millis *= Math.pow(10, fractionDigits - 3);
    for (int i = chars.length - 1; i >= 0; i--) {
        if (i == integerDigits) {
            chars[i] = '.';
            i--;
        }

        chars[i] = (char) (millis % 10);
        chars[i] += '0';

        millis /= 10;
    }

    return new String(chars);
}