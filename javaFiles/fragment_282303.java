public static int[] plusTen(int[] array)
 {
   int plusTenArray = new int[array.length];

   for(int i=0; i<array.length; i++) {
        plusTenArray[i] = array[i] + 10;
    }

 return plusTenArray;
}