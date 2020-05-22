// Excerpt from  @(#)Matcher.java   1.64 06/04/07

public String replaceFirst(String replacement) {
    if (replacement == null)
        throw new NullPointerException("replacement");
    StringBuffer sb = new StringBuffer();
    reset(); // !!!!
    if (find())
        appendReplacement(sb, replacement);
    appendTail(sb);
    return sb.toString();
}

public String replaceAll(String replacement) {
    reset(); // !!!!
    boolean result = find();
    if (result) {
        StringBuffer sb = new StringBuffer();
        do {
            appendReplacement(sb, replacement);
            result = find();
        } while (result);
        appendTail(sb);
        return sb.toString();
    }
    return text.toString();
}