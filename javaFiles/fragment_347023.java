public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char gameAnswer = 'y';

    do {
        System.out.println("Choose an animal: ");
        String text = input.nextLine();
        boolean known = getLegs(input, text);
        if (!known) {
            System.out.println("I don't know that animal. Do you want to try again? (y/n)");
            String tmp = input.nextLine().trim();
            if (!tmp.isEmpty()) {
                gameAnswer = tmp.charAt(0);
            }
        }
    } while (gameAnswer == 'y');

}

private static boolean getLegs(Scanner input, String animal) {
    boolean known = identifyAnimal(animal);
    if (known) {
        System.out.printf("How many legs does a %s have?\n", animal);
        int legs = input.nextInt();
        if (checkDog(animal, legs) || checkChicken(animal, legs) || checkFish(animal, legs)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
        /*
        known = true;
        input.nextLine();
        */ 
        return; // since the OP stated in the comments that he wants the code to exit here.
    }
    return known;
}

private static boolean identifyAnimal(String animal) {
    return "dog".equals(animal) || "chicken".equals(animal) || "fish".equals(animal);
}

private static boolean checkDog(String animal, int legs) {
    return legs == 4 && "dog".equals(animal);
}

private static boolean checkChicken(String animal, int legs) {
    return legs == 2 && "chicken".equals(animal);
}

private static boolean checkFish(String animal, int legs) {
    return legs == 0 && "fish".equals(animal);
}