public static void main(String[] args) {
    // We will add all user inputs (repesented as array of size 4) to this list.
    List<double[]> allNumbers = new ArrayList<>();

    do {
        double[] numbers = askForFourDigits();
        allNumbers.add(numbers);

        displayCurrentCycle(numbers);
        displayAll(allNumbers);
    } while(/* hey user, do you want to continue */);
}