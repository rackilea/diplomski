// get number from user
char input[100];
fgets(input, sizeof input, stdin);
int number = strtol(input, NULL, 10);
// print its square: possible integer-overflow if number * number > INT_MAX
printf("%i^2 = %i\n", number, number * number);