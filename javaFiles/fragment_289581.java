public ChangeJar(int amount) {
    // How many quarters?
    int quarters = amount / 25;
    amount = amount - quarters * 25;
    System.out.println(quarters + " quarters. Remains: " + amount);

    // How many dimes?
    int dimes = amount / 10;
    amount = amount - dimes * 10;
    System.out.println(dimes + " dimes. Remains: " + amount);

    // How many nickels?
    int nickels = amount / 5;
    amount = amount - nickels * 5;
    System.out.println(nickels + " nickels. Remains: " + amount);

    // How many pennies?
    int pennies = amount;
    amount = amount - pennies;
    System.out.println(pennies + " pennies. Remains: " + amount);

    // Prints:
    // 11 quarters. Remains: 12
    // 1 dimes. Remains: 2
    // 0 nickels. Remains: 2
    // 2 pennies. Remains: 0

    // Now we just set this in our properties:
    this.quarters = quartes;
    this.dimes = dimes;
    this.nickels = nickels;
    this.pennies = pennies;
}