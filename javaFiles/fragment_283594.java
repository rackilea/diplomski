num1 = 57;
num2 = 34;
int tempNum2 = num2;
while ( num1 > 0 ) {

    digit1 = num1 % 10;
    num1 = num1 / 10;
    System.out.println("num1 digit: " + digit1);

    while (tempNum2 > 0 ) {
        digit2 = tempNum2 % 10;
        System.out.println("num2 digit: " + digit2);
        tempNum2 = tempNum2 / 10;
    }
    tempNum2 = num2;
}