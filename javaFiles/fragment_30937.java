/**
 * @param input the input numbers
 * @param min   the minimum input number (min(input))
 * @param max   the maximum input number (max(input))
 * @return      the frequency of all input numbers as array. The n-th array element denotes the frequence of the number n+min.
 */
int[] frequency(int[] input, int min, int max) {
    int[] result = new int[max - min + 1];  // e.g. int[4] for min = 2 and max = 5
    for(int i = 0; i < input.length; ++i) { // iterate all input numbers
        int n = input[i];    // the number
        int index = n - min; // the index in the frequency array
        result[index]++;
    }
    return result;
}