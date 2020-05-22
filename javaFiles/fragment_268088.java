double num1 = 0;
double num2 = 0;

int errors = -1;
do {

    // Increment errors every time you go through the loop.
    // The first time you go through it doesn't really count since we set errors to -1
    errors++;

    if (errors > 0) {
        // If we are here, it's because there was an error
        System.out.println("Error: try again");
    }

    // Here you read a variable with Scanner. Technically you only need one, but I'm reusing your code.
    Scanner a=new Scanner(System.in);
    System.out.println("Please enter whole number: ");
    num1=a.nextDouble();

    Scanner b=new Scanner(System.in);
    System.out.println("Please enter whole number: ");
    num2=b.nextDouble();
} while (Math.floor(num1)!=num1 || Math.floor(num2)!=num2);

System.out.println("Great job!");
System.out.println("Addition: "+(num1+num2));
System.out.println("Subtraction: "+(num1-num2));