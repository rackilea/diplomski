public static void main(String[] args) {

    System.out.println(sumOfDigits(54));
}

public static int sumOfDigits(int num) {
    int sum = 0;
    char digit;
    for(int x = 0;x < (Integer.toString(num).length()); x++) {
        digit = Integer.toString(num).charAt(x);
        //This Prints 'Sum: 0 Digit: 5'
        System.out.println("Sum:" + sum + " Digit: " + digit);
        sum += (digit - '0');
        //This Prints 'Sum: 53 Digit: 5'
        System.out.println("Sum: " + sum + " Digit: " + digit);
    }
    return(sum);
}