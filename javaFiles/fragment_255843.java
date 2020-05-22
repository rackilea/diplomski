public static void freq() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // Count the number of times each sequence appeared. The array is indexed by the length of a sequence
    int[] counts = new int[str.length()];
    int current = 0;
    for (char value : str.toCharArray()) {
        if (value == 'H') {
            current++;
        } else if (current != 0){
            counts[current]++;
            current = 0;
        }
    }
    // If we end with 'H', increment the count
    if (current != 0) { counts[current]++; }

    // From the computed counts, find the one that appears the most often
    int mostFrequentLength = 0;
    int mostFrequentValue = 0;
    for (int i = 1; i < counts.length; i++) {
        if (counts[i] >= mostFrequentValue) {
            mostFrequentValue = counts[i];
            mostFrequentLength = i;
        }
    }

    System.out.println(mostFrequentLength);
}