public static long sumTheDigits(long currentIterationValue){

    long currentDigitValue;
    long sumOutputValue = 0;

    while(currentIterationValue != 0) {
        currentDigitValue = currentIterationValue % 10;
        currentIterationValue = currentIterationValue / 10;
        sumOutputValue = sumOutputValue + currentDigitValue;
    }
    return sumOutputValue;
}