char c = 'a' - 1;
for (int i = word.length(); i < 26; i++) {
    // loop until we find a char not contained in `word`
    while (word.contains(String.valueOf(++c)));
    keyword[i] = c;
}