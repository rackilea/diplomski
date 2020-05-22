public static boolean allLessThan(Collection<Integer> numbers, Integer value) {
   for (Integer each : numbers) {
      if (each >= value) {
         return false;
      }
   }
   return true;
}