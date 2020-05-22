public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many Inputs??");
    int numOfInputs = input.nextInt();
    String[] dataStore = new String[numOfInputs];
    System.out.println("Input Strings");

    for (int i = 0; i < numOfInputs; i++) {
        dataStore[i] = input.next();
        System.out.println("Input " + (i + 1) + " = " + dataStore[i]);

    }
}