Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter a number: ");
    int num = scanner.nextInt();

    System.out.println("Please enter a string: ");
    String str = scanner.next();

    Palindrome palin = new Palindrome();
    int revNum = palin.reverse(num);

    if (num == revNum) {
        System.out.printf("\n The number %d is a Palindrome ", num);
    } else {
        System.out.printf("\n The number %d is not a Palindrome ", num);
    }