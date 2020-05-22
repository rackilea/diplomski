private static final int DAYS_IN_YEAR = 365;
private static final int NUMBER_OF_SIMULATIONS = 500;
private Random rnd = new Random();
private int generateBirthday() {
    return this.rnd.nextInt(DAYS_IN_YEAR);
}
private boolean iteration(int numberOfStudents) { //one iteration from the simulation
    boolean[] present = new boolean[DAYS_IN_YEAR];
    for (int i = 0; i < numberOfStudents; i++) {
        int birthday = generateBirthday();
        if (present[birthday])
            return true;
        present[birthday] = true;
    }
    return false;
}
void simulation(int numberOfStudents){
    int count = 0;
    for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++)
        if (iteration(numberOfStudents))
            count++;
    System.out.printf("For n=%d -> P=%.4f%n", numberOfStudents, (double)count/NUMBER_OF_SIMULATIONS);
}