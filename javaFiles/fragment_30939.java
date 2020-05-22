/**
 * Computes the frequencies of the given input numbers.
 * @returns the frequencies of the input numbers as two-dimensional array. The first element of the array is an array of the frequencies, the second element the array of numbers. 
 */
int[][] frequencies(int[] input) {
    // get min/max of input
    int[] minMax = boundaries(input);
    int min = minMax[0];
    int max = minMax[1];

    // compute frequencies
    int[] frequencies = frequency(input, min, max);

    // create numbers array
    int[] numbers = new int[frequencies.length]);
    for(int i = 0; < frequency.length; ++i) {
       numbers[i] = min + i;
    }

    // assembly two dimensional result array
    return new int[][] { frequencies, numbers };
}