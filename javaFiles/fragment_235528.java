public List<String> encodings(String number) {
    List<String> out = new ArrayList<>();
    addEncodings("", number, out);
    return out;
}

private void addEncodings(String prefix, String number, List<String> out) {
    if (number.length() == 0) {
        out.add(prefix);
    } else {
        addParsingNDigits(1, prefix, number, out);
        addParsingNDigits(2, prefix, number, out);
    }

}

private void addParsingNDigits(int digits, String prefix, String number, List<String> out) {
    if (number.length() >= digits) {
        char encodedChar = parseChars(number, digits);
        if (encodedChar >= 'A' && encodedChar <= 'Z') {
            addEncodings(prefix + encodedChar, number.substring(digits), out);
        }
    }
}

private char parseChars(String number, int length) {
    int intVal = Integer.parseInt(number.substring(0, length));
    return (char) ('A' + intVal - 1);
}