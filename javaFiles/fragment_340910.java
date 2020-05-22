public int sumNumbers(String str) {
    int sPos = -1;
    int ePos = -1;
    int sum = 0;

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (Character.isDigit(c)) {
            if (sPos < 0) {
                sPos = i;
                ePos = i;
            } else {
                ePos = i;
            }
        } else {
            sum = add(str, sum, sPos, ePos);
            sPos = -1;
        }
    }

    sum = add(str, sum, sPos, ePos);

    return sum;
}

private int add(String str, int sum, int sPos, int ePos) {
    if (sPos >= 0) {
        sum += Integer.parseInt(str.substring(sPos, ePos + 1));
    }
    return sum;
}