Integer strength = null;
while (strength == null) {
    System.out.println("Enter the amount of stength for Human (0-18): ");
    strength = input.nextInt();

    if (strength < 0 || strength > 18) {
        strength = null;
        System.out.println("Invalid strength, please try again");
    }
}