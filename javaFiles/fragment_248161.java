private static String leftPad(String s, int length) {
    if (s.length() >= length)
        return s;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length - s.length(); i++)
        sb.append("0");

    return sb.toString() + s;
}

public static String add(String originalA, String originalB) {

    int maxLength = Math.max(originalA.length(), originalB.length());
    String a = leftPad(originalA, maxLength);
    String b = leftPad(originalB, maxLength);

    ... rest of your method