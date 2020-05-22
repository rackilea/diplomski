public int reduceToOneDigit(int inputNumber){
    int result = 1;
    while(inputNumber > 0){
        result *= (inputNumber % 10);
        inputNumber /= 10;
    }
    if (result > 9)
        result = reduceToOneDigit(result);
    return result;
}