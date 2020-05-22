class CombinedString {
   final String combinedValue;
   final String[] substrings;
   final int[] substringPositions;

   public CombinedString(String initial) {
       combinedValue = initial;
       substrings = {initial};
       substringPositions = [0]; // first string inserted at position 0
   }

   public CombinedString(CombinedString left, CombinedString right) {
       // ...
   }

   // ...
}