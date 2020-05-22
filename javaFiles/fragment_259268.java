public void printPrice() {
    scanner = new Scanner(System.in);

    initialBookPrice = inputReader("Initial Book Price");

    discountPrice = inputReader("Discount Price");

    basePrice= inputReader("Base Price");

    budget= inputReader("Budget");

    if (budget < initialBookPrice) {
        System.out.printf("0 Books, $%s remaining", budget);
    } else if (budget == initialBookPrice) {
        System.out.printf("1 Book, $0 remaining");
    } else {
        System.out.println(offerFunction());
    }

}