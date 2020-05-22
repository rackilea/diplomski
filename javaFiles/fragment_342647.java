for(int i =1;i<10;i++) {
        System.out.println("Please enter description(e.g.apple,banana,orange):");
        String description =input.nextLine();
        System.out.println("Please enter Price(e.g.4.0,5.99):");
        Double price = scanner.nextDouble();
testInvoice.addItem(new Item(description, price));
}