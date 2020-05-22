public static void main(String[] args) {
    System.out.println(isAggregatedNumber("111121325"));// true
    System.out.println(isAggregatedNumber("122436"));// true
    System.out.println(isAggregatedNumber("122437"));// false
    System.out.println(isAggregatedNumber("1299111210"));// true
    System.out.println(isAggregatedNumber("112112224"));// true
    System.out.println(isAggregatedNumber("112012224"));// false
}

static boolean isAggregatedNumber(String text) {
    int length = text.length();
    for (int i = 1; i <= length / 2; i++) { // length of the first number should not exceed half of the length of the entire number
        for (int j = i + 1; j <= length - Math.max(i, j - i); j++) { // length of the first & second number should not exceed length of the entire number minus length of the first number or the second, whichever is bigger
            if (Match(i, j, text)) {
                return true;
            }
        }
    }
    return false;
}

static boolean Match(int i, int j, String text) {
    String first = text.substring(0, i);
    String second = text.substring(i, j);
    StringBuilder buffer = new StringBuilder(first);
    buffer.append(second);
    while (buffer.length() < text.length()) {
        Integer x = (Integer.parseInt(first) + Integer.parseInt(second));
        String third = x.toString();
        buffer.append(third);
        first = second;
        second = third;
    }
    if (text.equals(buffer.toString()))
        return true;
    return false;
}