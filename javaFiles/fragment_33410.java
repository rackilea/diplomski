int number = 4;
int currentNumber = 0;
while (++number <= 100 && currentNumber < 100) {
    currentNumber = number * number;
    pw.println("your numbers are " + currentNumber);
}