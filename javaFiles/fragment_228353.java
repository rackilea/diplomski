Scanner sc = new Scanner(System.in);
    System.out.println("Enter numbers (0 to end):");
    int sum = 0;
    int number;
    do {
        while (!sc.hasNextInt()) {
            System.out.println("I'm sorry, that's not a number! Try again!");
            sc.next();
        }
        number = sc.nextInt();
        sum += number;
    } while (number != 0);
    System.out.println("The sum of those numbers is " + sum);