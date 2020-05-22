Scanner input = new Scanner(System.in);
    System.out.println("Please enter description(e.g.apple,banana,orange):");
    String description =input.nextLine();
    System.out.println("Please enter Price(e.g.4.0,5.99):");
    Double price = scanner.nextDouble();
    Item testItem = new Item(description, price);