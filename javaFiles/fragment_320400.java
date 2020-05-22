public static char[] replaceSets(char[] input) {
    if (input.length < 3) {
        return input;
    }

    for (int i = 0; i < input.length - 3; ++i) {
        if (input[i] == input[i + 1] && input[i + 1] == input[i + 2]) {
            input[i] = 'x';
            input[i + 1] = 'x';
            input[i + 2] = 'x';
            i += 2;
        }
    }

    return input;
}