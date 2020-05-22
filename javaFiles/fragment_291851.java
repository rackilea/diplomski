char[] copyLoop = new char[26];
    int dst = 0;
    for (int i = 0; i < letters.length; i++) {
        if (letters[i] > 1) {
            char c = (char) (i + 97);
            copyLoop[dst++] = c;       
        }
    }
    return new String(copyLoop, 0, dst);