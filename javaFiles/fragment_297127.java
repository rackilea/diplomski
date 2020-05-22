if (match.equals(patteren)) {
    if (pos - 1 >= 0
            && Character.isWhitespace(doc.getText(pos - 1, 1).charAt(0))) {
        if (pos + findLength == doc.getLength()
                || Character.isWhitespace(doc.getText(pos + findLength, 1).charAt(0))) {
            found = true;
            break;
        }
    }
}