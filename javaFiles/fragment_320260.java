/**
* @param target the number you want the factor to be close to
* @param number the number you want the result to be a factor of
*/
private static int getClosestFactor(int target, int number) {
    for (int i = 0; i < number; i++) {
        if (number % (target + i) == 0) {
            return target + i;
        } else if (number % (target - i) == 0) {
            return target - i;
        }
    }
    return number;
}