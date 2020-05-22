public int scramble(int number) {
    String numberString = Integer.toString(number);
    int numberLength = numberString.length();
    String result = "";
    for (int i = 0; i < (numberLength + 2) / 2; i++) {
        result += numberString.charAt(i);
        result += numberString.charAt(numberLength - i - 1);
    }
    //Making sure that the resulting string is the same length as the original
    //Initially, the result for a number with an odd number of digits, such as 12345
    //will be 152344. So you need to make sure the last digit is removed.
    result = result.substring(0, numberLength);
    return Integer.parseInt(result);
}