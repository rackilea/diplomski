public int getInteger() {
    Scanner keyboard = new Scanner(System.in);
    Integer value = null;

    while (value == null) {
        try {
            System.out.println("Please enter integer");
            value = keyboard.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter integer only!");
        }
    }

    return value;
}