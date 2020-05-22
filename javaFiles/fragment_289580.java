public ChangeJar(double amount) {
    // How many quarters?
    int quarters = (int) (amount / .25); // The division gives 9.48 and we cast the result to int so we get 9
    amount = amount - quarters * .25;
    System.out.println(quarters + " quarters. Remains: " + amount);

    // How many dimes?
    int dimes = (int) (amount / .10);
    amount = amount - dimes * .10;
    System.out.println(dimes + " dimes. Remains: " + amount);

    // How many nickels?
    int nickels = (int) (amount / .05);
    amount = amount - nickels * .05;
    System.out.println(nickels + " nickels. Remains: " + amount);

    // How many pennies?
    int pennies = (int) (amount / .01);
    amount = amount - pennies * .01;
    System.out.println(pennies + " pennies. Remains: " + amount);

    // Prints:
    // 11 quarters. Remains: 0.1200000000000001
    // 1 dimes. Remains: 0.0200000000000001
    // 0 nickels. Remains: 0.0200000000000001
    // 2 pennies. Remains: 1.0061396160665481E-16

    // Now we just set this in our properties:
    this.quarters = quartes;
    this.dimes = dimes;
    this.nickels = nickels;
    this.pennies = pennies;
}