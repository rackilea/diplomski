if (letters > 0) {
    // variable contains any English letters
}

if (letters == text.length()) {
    // variable contains only English letters
}

if ((double)letters/(double)text.length() >= (double)X/100.0) {
    // at least X% of chars are letters
}

if (text.length() > 0 && Character.isLetter(text.charAt(0))) {
    // starts with letter
}