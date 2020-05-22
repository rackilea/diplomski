public void uniqueM(int arrayA[], int arrayB[]){
    boolean uniqueA = true, uniqueB = true;
    int high_size = arrayA.length, low_size = arrayB.length;

   if(arrayA.length < arrayB.length){
     low_size = arrayA.length;
     high_size = arrayB.length;
    }

    for(int i = 0; i < high_size; i++){
      for(int j = 0; j < low_size;j++)
      {
         if(i < arrayA.length && arrayA[i] == arrayB[j]) uniqueA = false;
         if(i < arrayB.length && arrayB[i] == arrayA[j]) uniqueB = false;
      }
       if(uniqueA && i < arrayA.length) System.out.println(arrayA[i]);
       if(uniqueB && i < arrayB.length) System.out.println(arrayB[i]);

       uniqueA = true;
       uniqueB = true;
    }
}