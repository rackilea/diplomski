public static double maximum(int[] numbers) {
       int maxValue = 0;
       for (int index = 0; index < numbers.length; index++) {
           if (maxValue < numbers[index]){
              maxValue = numbers[index];
           }
       }
       return maxValue;
    }