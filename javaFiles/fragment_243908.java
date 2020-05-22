public static void main(String[] args) 
{
    flavorFactory = new CoffeeFlavorFactory();
    CoffeeFlavor a = flavorFactory.getCoffeeFlavor("espresso");
    CoffeeFlavor b = flavorFactory.getCoffeeFlavor("espresso");
    CoffeeFlavor c = flavorFactory.getCoffeeFlavor("espresso");

    // This is comparing the reference value, not the contents of the objects
    if (a == b && b == c)
        System.out.println("I have three references to the same object!");
}