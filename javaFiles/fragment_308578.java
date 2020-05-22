public int reduceToOneDigitNoRecursion(int inputNumber){
    int result = 1;
    do{
          while(inputNumber > 0){
              result *= (inputNumber % 10);
              inputNumber /= 10;
          }
    }
    while(result > 9);
    return result;
}