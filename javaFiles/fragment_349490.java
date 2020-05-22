boolean insideQuotes = false;
for (int i = 0; i < chars.length; i++) {
    if (chars[i] == '\'' || chars[i] == '"') {
        insideQuotes = !insideQuotes;
    } else if (!insideQuotes) {
        chars[i] = Character.toLowerCase(chars[i]);
    }
}