public static String removeConsecutiveChars(String str) {

        if (str == null) {
            return null;
        }

        int strLen = str.length();
        if (strLen <= 1) {
            return str;
        }

        char[] strChar = str.toCharArray();
        char temp = strChar[0];

        StringBuilder stringBuilder = new StringBuilder(strLen);
        for (int i = 1; i < strLen; i++) {

            char val = strChar[i];
            if (val != temp) {
                stringBuilder.append(temp);
                temp = val;
            }
        }
        stringBuilder.append(temp);

        return stringBuilder.toString();
    }