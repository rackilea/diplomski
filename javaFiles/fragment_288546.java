public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();

    while (sc.hasNextInt())
        numbers.add(sc.nextInt());
    sc.close(); // Remember to close the input stream when finished

    double total = 0;
    for (int num : numbers) // Loop through all ints in the list
        total += num; // Add each int to total

    double average = total / numbers.size();
    System.out.println("The average is: " + average);
    System.out.println(numbers);
}