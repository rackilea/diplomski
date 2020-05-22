public int[] extractPositives(int[] intArray) {

   int count = 0;
   for (int i = 0; i < intArray.length; i++) {
         if (intArray[i] >= 0)
           count++;
    }

   if(count == 0){
               return null;
   }

   int[] array = new int[count];
   count = 0;
   for (int i = 0; i < intArray.length; i++) {
         if (intArray[i] >= 0)
            array[count++] = intArray[i];
   }
return array;