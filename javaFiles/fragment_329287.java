public void beveragechoice() {
    double prices[] = {2.49, 1.25, 3.49, 3.25, 2,25, 1.30, 3.40, 3.49, 2.50, 3.00};
    System.out.println("Select one beverage");
    Scanner c = new Scanner(System.in);
    int choice = c.nextInt();
    if (choice > 0 && choice <= prices.length) {
        double p = prices[choice - 1];
        System.out.println("This beverage costs $" + p);
        System.out.println("Enter money put into the machine: ");
        double money = c.nextDouble();
        if (money == p) {
            System.out.println("No change.");
        } else {
            System.out.println("Your change is: $" + (money - p));
        }
    }
}