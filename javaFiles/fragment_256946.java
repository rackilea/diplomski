public static int parseInt(String str) throws IllegalArgumentException {
    int answer = 0, factor = 1;

    boolean isNegative = false;
    if(str.charAt(0) == '-') {
        isNegative = true;
    }

    for (int i = str.length()-1; i >= (isNegative ? 1 : 0); i--) {
        int nextInt = (str.charAt(i) - '0') * factor;

        if(isNegative && answer > Math.abs(Integer.MIN_VALUE + nextInt))
            throw new IllegalArgumentException();
        else if(!isNegative && answer > Integer.MAX_VALUE - nextInt)
            throw new IllegalArgumentException();

        answer += nextInt;
        factor *= 10;
    }

    if (isNegative) {
        answer = -answer;
    }

    return answer;
}