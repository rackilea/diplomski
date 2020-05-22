String[] operationSet = new String[]{"+", "-", "/", "*"};

public void testGenerateRandomEquations() {

    Random random = new Random();
    int numOfOperations = random.nextInt(2) + 1;

    List<String> operations = new ArrayList<>();

    for (int i = 0; i < numOfOperations; i++) {
        String operation = operationSet[random.nextInt(3)];
        operations.add(operation);
    }

    int numOfNumbers = numOfOperations + 1;
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < numOfNumbers; i++) {
        int number = random.nextInt(Integer.MAX_VALUE) - random.nextInt(Integer.MAX_VALUE);
        numbers.add(number);
    }
    //Now you've the list of random numbers and operations. You can further randomize
    //by randomly choosing the number and operation from those list.
}