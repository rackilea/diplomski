Scanner input = new Scanner(System.in);

System.out.print("Enter first number: "); // prompt
double number1 = Math.min(input.nextDouble(), 100); // first number to add

System.out.print("Enter second number: "); // prompt
double number2 = input.nextDouble(); // read second number from user

double sum = number1 + number2; // add numbers, then store total in sum

System.out.printf("Sum is %.0f\n", sum); // display sum