Scanner scannerNum1 = new Scanner(System.in);
Scanner scannerNum2 = new Scanner(System.in);
float result = 0;

System.out.println("What is your first number?");
int num1 = scannerNum1.nextInt();
System.out.println("What is your second number?");
int num2 = scannerNum2.nextInt();
switch (Operation) {
    case "addition":
        result = num1 + num2;
        break;
    case "subtraction":
        result = num1 - num2;
        break;
    case "multiplication":
        result = num1 * num2;
        break;
    case "division":
        result = num1 / num2;
        break;
}