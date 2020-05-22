public void generateCustomerID(String id, int numbersInID) {
    //incNumber stands for incremented number
    int incNumber = 0;
    //create a new array of numbers as big as the user has defined
    int[] numbers = new int[numbersInID];
    while(incNumber < numbersInID) {
        //add a new number to the array between 0 and 10
        numbers[incNumber] = randomGenerator.nextInt(10);
        incNumber++;
    }
    System.out.print(id);
    for(int number: numbers)
        System.out.print(number);
}