public T[] shuffleArray(final T[] inputArray) {
    T[] result = Arrays.copyOf(inputArray, inputArray.length);
    int index;
    Random random = new Random();
    for (int i = result.length - 1; i > 0; i--) {
        index = random.nextInt(i + 1);
        if (index != i) {
            swap(result, i, index);
        }
    }
    return result;
}