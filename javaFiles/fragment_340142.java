final char seperatorChar = ',';
final Pattern p = Pattern.compile("[0-9" + seperatorChar + "]*");
textField.setTextFormatter(new TextFormatter<>(c -> {
    if (!c.isContentChange()) {
        return c; // no need for modification, if only the selection changes
    }
    String newText = c.getControlNewText();
    if (newText.isEmpty()) {
        return c;
    }
    if (!p.matcher(newText).matches()) {
        return null; // invalid change
    }

    // invert everything before the range
    int suffixCount = c.getControlText().length() - c.getRangeEnd();
    int digits = suffixCount - suffixCount / 4;
    StringBuilder sb = new StringBuilder();

    // insert seperator just before caret, if necessary
    if (digits % 3 == 0 && digits > 0 && suffixCount % 4 != 0) {
        sb.append(seperatorChar);
    }

    // add the rest of the digits in reversed order
    for (int i = c.getRangeStart() + c.getText().length() - 1; i >= 0; i--) {
        char letter = newText.charAt(i);
        if (Character.isDigit(letter)) {
            sb.append(letter);
            digits++;
            if (digits % 3 == 0) {
                sb.append(seperatorChar);
            }
        }
    }

    // remove seperator char, if added as last char
    if (digits % 3 == 0) {
        sb.deleteCharAt(sb.length() - 1);
    }
    sb.reverse();
    int length = sb.length();

    // replace with modified text
    c.setRange(0, c.getRangeEnd());
    c.setText(sb.toString());
    c.setCaretPosition(length);
    c.setAnchor(length);

    return c;
}));