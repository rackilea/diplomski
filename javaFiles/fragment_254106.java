public void getMessage(int numEggs) {

    int a = numEggs / 12;
    int b = numEggs % 12;

    if (numEggs < 0) {
        System.out.println("Invalid number");
    } else {
        System.out.println("Your number of eggs is " + a + " dozen(s) and "
                + b + ".");
        return;
    }
}