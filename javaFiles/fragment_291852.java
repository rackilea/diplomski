StringBuilder copyLoop = new StringBuilder(26);
    for (int i = 0; i < letters.length; i++) {
        if (letters[i] > 1) {
            char c = (char) (i + 97);
            copyLoop.append(c);       
        }
    }
    return copyLoop.toString();