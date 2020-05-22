public static double mean(ArrayList<Double> numbers) {
   double sum = 0;
   for (int i = 0; i < numbers.size(); i++) {
     sum += numbers.get(i);
   }
  return sum / numbers.size();
}