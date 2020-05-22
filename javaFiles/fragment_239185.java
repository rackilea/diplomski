public void getTotalCost(){
    double totalAmount = 0.0;
    System.out.println();
    for (int i = 0; i < counter; i++) {
        totalAmount += list[i].getCost_Food() * list[i].getQuantity_Food();
        System.out.format("%6s %-15S %10gKR. %4d stk.%n", "",
                        list[i].getName_Food(),
                        list[i].getCost_Food(),
                        list[i].getQuantity_Food()
        );
    }
    System.out.println("The Total Amount is: " + totalAmount);
}