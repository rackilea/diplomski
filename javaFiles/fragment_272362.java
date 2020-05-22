int loopFor = 0;
Scanner scanner = new Scanner(System.in);//we create a Scanner object

do {
    System.out.println("Enter a Number:");
    int numToAdd = scanner.nextInt();//We use it's method to read the number.
    loopFor += numToAdd;
} while (loopFor != 0);