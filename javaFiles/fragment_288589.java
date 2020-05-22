private static String HighOrLow (int[] numbers){
 for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] > average) {
         return (numbers[i] + "is above the average");
    }
    else if (numbers[i] < average) {
         return (numbers[i] + " is below the average");
    }
    else   {
         return (numbers[i] + " is equal to the average");
   }
  }
  return "No numbers founds";
}