if (match.equals(patteren)) {
    if (pos - 1 >= 0 && 
            doc.getText(pos - 1, 1).equals(" ")) {
        if (pos + findLength == doc.getLength() ||
                doc.getText(pos + findLength, 1).equals(" ")) {
            found = true;
            break;
        }
    }
}