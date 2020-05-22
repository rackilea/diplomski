Scanner in = new Scanner(System.in);
do {
    System.out.print("Enter a number between 2 and 15: ");
    posNumber = in.nextLong();

    for (x = 1; x <= posNumber; x++)
      fact = fact*x;
      System.out.println("Factorial of " +posNumber+ " is " +fact);
    }
} while (posNumber >= 2 || posNumber <= 15);