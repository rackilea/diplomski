public static int binaryToNumber (String numberInput) {
    int currentPower = 1;
    int total = 0;

    for (int i = numberInput.length() - 1; i >= 0; i--) {
        if (numberInput.charAt(i) == '1')  {
            total += currentPower;
        }
        currentPower *= 2;
    }

    return total;
}