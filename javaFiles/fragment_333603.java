int number = input;
int sum = 0;
while (number > 0) {
    int digit = number % 10;
    sum += digit * digit * digit;
    number /= 10;
}