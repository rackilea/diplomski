FoodType chosenType = FoodType.SANDWITCH; // can be user input

switch (chosenType) {
case SANDWITCH:
    System.out.println("you want cheese?");
case SALAD:
    System.out.println("Sauce?");
    break;
case FRUIT:
    System.out.println("which one?");
    break;
default:
    throw new IllegalStateException();
}