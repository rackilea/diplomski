Scanner scanner = new Scanner(System.in);
while(true) {
    System.out.println("Enter an int value");
    if(scanner.hasNextInt()) {
        int token = scanner.nextInt();
        System.out.println(token);
        break;
    }else {
        scanner.nextLine();
        continue;
    }
}