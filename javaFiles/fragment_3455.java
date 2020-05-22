public static int letterToCode(char letter) {
    if (letter >= '0' && letter <= '9') {
        return letter - '0';
    } else if (letter >= 'A' && letter <= 'Z') {
        return letter - 'A' + 10;
    } else {
        throw new IllegalArgumentException("Invalid letter: " + letter);
    }
}

public static char codeToLetter(int code) {
    if (code >= 0 && code <= 9) {
        return (char) ('0' + code);
    } else if (code >= 10 && code <= 35) {
        return (char) ('A' + code - 10);
    } else {
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}