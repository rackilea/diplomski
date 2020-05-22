public static String editing(String sentences) {
    StringBuilder sb = new StringBuilder();
    sb.append(sentences.charAt(0));
    for (int i = 1; i < sentences.length(); i++) {
        char c = sentences.charAt(i);
        if (Character.isUpperCase(c)) {
            sb.append(" ");
            c = Character.toLowerCase(c);
        }
        sb.append(c);
    }
    return sb.toString();
}