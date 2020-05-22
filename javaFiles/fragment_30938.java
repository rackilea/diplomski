/**
 * Computes the boundaries (minimum and maximum) of the given number array
 * @param input the input numbers
 * @return      the minimum and maximum number of the input numbers as array of length 2. The first element is the minimum, the second element the maximum value.
 */
int[] boundaries(int[] input) {
    int[] result = new int[2]; // result[0] = min, result[1] = max
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for(int i = 0; i < input.length; ++i) {
        int n = input[i];
        min = Math.min(min, n);
        max = Math.max(max, n);
    }

    return new int[] { min, max };
}