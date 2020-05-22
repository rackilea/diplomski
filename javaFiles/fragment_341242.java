public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int[] listOfInt = new int[10];// 10 integers MAX

    System.out.println("Enter " + listOfInt.length + " integers: ");
    for (int count = 0; count < listOfInt.length; count++) {
        listOfInt[count] = keyboard.nextInt();
    }
    int sum = 0;
    for (int i : listOfInt) {
        sum += i;
    }
    double average = ((double) sum) / listOfInt.length;
    System.out.printf("Average: %.2f%n", average);
    List<Integer> aboveAverage = new ArrayList<>();
    for (int v : listOfInt) {
        if (v > average) {
            aboveAverage.add(v);
        }
    }
    System.out.printf("There are %d numbers above the average%n",
            aboveAverage.size());
    System.out.printf("Those numbers are: %s%n", aboveAverage);
}