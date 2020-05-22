StringBuilder utfRepresentation = new StringBuilder();
for (int index = 0; index < input.length(); index++) {
    char ch = input.charAt(index);
    if (ch < 128) {
        utfRepresentation.append(ch);
    } else {
        utfRepresentation.append(String.format("\\u%04X", ch));
    }
}