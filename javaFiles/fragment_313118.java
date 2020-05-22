public static String parseText(String text) {
    StringBuilder oldText = new StringBuilder(text);
    StringBuilder newText = new StringBuilder();
    int firstTag = oldText.indexOf("{");
    FullBreak:
    while (firstTag >= 0) {
        newText.append(oldText.substring(0, firstTag));
        oldText.delete(0, firstTag);
        int depth = 1;
        int position = 0;
        while (depth > 0) {
            position++;
            if (position > oldText.length() - 1) {
                break FullBreak;
            }
            if (oldText.charAt(position) == '{' && oldText.charAt(position - 1) != '\\') {
                depth++;
            }
            if (oldText.charAt(position) == '}' && oldText.charAt(position - 1) != '\\') {
                depth--;
            }
        }
        position++;
        newText.append(parseTag(oldText.substring(0, position)).render());
        oldText.delete(0, position);
        firstTag = oldText.indexOf("{");
    }
    newText.append(oldText);
    return newText.toString();
}