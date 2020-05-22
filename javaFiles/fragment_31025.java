public static String calcAverage(int[] numbers){        // Returns a string
    //    Calculate the average value and return it
    double total = 0;
    for (int i = 0; i < numbers.length; i++){
         total = total + numbers[i];
    }

    String answer = "The average of all numbers is: \n" + (total / numbers.length);
    return answer;
}