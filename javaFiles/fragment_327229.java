public static int[][] permute(int[] numbers) {
    // Follow the original here and create an array of just 1 array of length 0
    int[][] permutations = new int[1][0];
    for (int i = 0; i < numbers.length; i++) {
        // insert numbers[i] into each possible position in each array already in permutations.
        // create array with enough room: when before we had permutations.length arrays, we will now need:
        int[][] current = new int[(permutations[0].length + 1) * permutations.length][];
        int count = 0; // number of new permutations in current
        for (int[] permutation : permutations) {
            // insert numbers[i] into each of the permutation.length + 1 possible positions of permutation.
            // to avoid too much shuffling, create a temp array
            // and use it for all new permutations made from permutation.
            int[] temp = Arrays.copyOf(permutation, permutation.length + 1);
            for (int j = permutation.length; j > 0; j--) {
                temp[j] = numbers[i];
                // remember to make a copy of the temp array
                current[count] = temp.clone();
                count++;
                // move element to make room for numbers[i] at next position to the left
                temp[j] = temp[j - 1];
            }
            temp[0] = numbers[i];
            current[count] = temp.clone();
            count++;
        }
        assert count == current.length : "" + count + " != " + current.length;
        permutations = current;
    }
    return permutations;
}