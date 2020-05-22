public static boolean checkDiagonals(int[][] array, int magicConstant){
   int total1 = 0;
   int total2 = 0;
   int wrong = 0;
   for(int i = 0; i < array.length; i++){
     total1= total1 + array[i][i];
     total2 = total2 + array[array.length - i-1][array.length - i-1];
   }
   if(total1!=magicConstant){
     wrong++;
  }
   if(total2!=magicConstant){
     wrong++;
  }
  System.out.println("There were " + wrong + " invalid diagnals.");
  return wrong == 0;
}