public static Set<Integer> randomUniqueNumbers(int amount, int upperBound){
    final HashSet<Integer> numbers = new HashSet<>();
    final Random rnd = new Random();

    // Stop when generated enough numbers
    while (numbers.size() < amount) {
        final int randomNumber = rnd.nextInt(upperBound);
        // Try to add it to the set.
        // The method will do nothing if the number was contained already.
        numbers.add(randomNumber);
    }

    return numbers;
}