public class ArrayCheck {
    /**
     * Tests all elements of the given array, if they are divisible by the given
     * divisor.
     *
     * @param arr
     *            array to be tested
     * @param divisor
     *            number by which all elements of the given array should be
     *            divisible
     * @return true if all elements are divisible by divisor
     */
    public boolean allDivisibleBy(ArrayList<Integer> arr, int divisor) {
        // check if number is dividable or if number is 0
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != 0) {
                if (divisor == 0)
                    return false;
                else if (arr.get(i) % divisor != 0)
                    return false;
            }
        }
        return true;
    }
}