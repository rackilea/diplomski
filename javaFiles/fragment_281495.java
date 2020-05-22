public static boolean isPositiveFirst(int[] numbers) {
    for(int i = 1; i < numbers.length; i++) {
       if(numbers[i] > 0 && numbers[i-1] <= 0) {
           return false;
       }
    }
    return true;
}