public int hashCode() {
   int result = 17;
   for (int i = 0; i < array.length; i++) {
      result = 31*result + (int)array[i];
   }
   return result;
}