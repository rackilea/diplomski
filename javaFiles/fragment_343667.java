import java.lang.reflect.Array;

 /**
  * Checks an arbitrary number of parallel arrays to verify that they have the same length.
  * @throws IllegalArgumentException if any of the arguments is not an array or if the lengths of the arrays are not equal.
  */
 public static void checkParallelArrays(Object... arrays) {
   if (arrays.length < 1) {
     return;
   }
   int expectedLength = Array.getLength(arrays[0]);
   for (int i=1; i<arrays.length; i++) {
     int length = Array.getLength(arrays[i]);
     if (length != expectedLength) {
       throw new IllegalArgumentException("Array " + i + " doesn't have expected length " + expectedLength + ": " + length);
     }
   }
 }