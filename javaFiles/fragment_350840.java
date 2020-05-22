public static String removeDigits(String text) {
        int length = text.length();
        StringBuffer buffer = new StringBuffer(length);
        for(int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (!Character.isDigit(ch)) {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }