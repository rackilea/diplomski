boolean match = true;
for (int i = 0; i < word.length(); i++) {
    if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
        match = false;
        break;
    }
}