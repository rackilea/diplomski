public boolean checkFibb(ArrayList<Integer> array1) {
   int i;
   int fibb;
   boolean isFibb = true;

   if (array1.size() < 3) {
       System.out.println("Your array is too short!");
       isFibb = false;
   } else {
       for (i = 0; i <= array1.size() - 2; i++) {
           fibb = array1.get(i + 2) - (array1.get(i + 1) + array1.get(i));

           if (fibb != 0) {
                System.out.println("Elements are not part of the Fibonacci sequence.");
                isFibb = false;
                break;
           } else {
                System.out.println("Elements are part of the Fibonacci sequence."); 
           }
       }
   }
   return isFibb;
}