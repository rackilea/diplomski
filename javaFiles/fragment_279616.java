public static int sumOfEvenPlaces(long number) {
    int sum = 0;
    int remainder;
    number /= 10;          // change 1
    while (number > 0) {   // change 2
        remainder = (int) (number % 10);
        sum = sum + getDigit(remainder * 2);
        number /= 100;
    }
    return sum;
}

public static int sumOfOddPlaces(long number) {
    int sum = 0;
    int remainder;

    while (number > 0) {   // change 3 
        remainder = (int) (number % 10);
        sum = sum + getDigit(remainder);
        number /= 100;
    }
    return sum;
}