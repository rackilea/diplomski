static String capitalizeString(String x) {
    StringBuilder completedConversion = new StringBuilder();

    for (int i = 0; i < x.length(); i++) {
        if (i == 0) {
            char ch = x.charAt(i);
            ch = Character.toUpperCase(ch);
            completedConversion.append(ch);
            i++;
        }

        if (!Character.isWhitespace(x.charAt(i - 1))) {
            char ch = x.charAt(i);
            completedConversion.append(ch);
        } else {
            char ch = x.charAt(i);
            ch = Character.toUpperCase(ch);
            completedConversion.append(ch);
        }

    }

    return completedConversion.toString();
}