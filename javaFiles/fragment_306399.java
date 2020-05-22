public static String[] parseExpression(String str) {
    List<String> list = new ArrayList<String>();
    StringBuilder currentDigits = new StringBuilder();

    for (char ch: str.toCharArray()) {
        if (Character.isDigit(ch)) {
            currentDigits.append(ch);
        } else {
            if (currentDigits.length() > 0) {
                list.add(currentDigits.toString());
                currentDigits = new StringBuilder();
            }
            list.add(String.valueOf(ch));
        }
    }

    if (currentDigits.length() > 0)
        list.add(currentDigits.toString());

    return list.toArray(new String[list.size()]);
}