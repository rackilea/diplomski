public static int[] eliminateDuplicates(int[] list){   
     int[] noDup = new int[list.length]; 
     noDup[0] = list[0];
     int noDupCount = 1;
     for (int c = 1; c < list.length-1; c++){
         boolean bAlreadyAdded = false;
         for (int d = 0; d < noDup.length-1; d++){
           if (noDup[d] == list[c]){
               bAlreadyAdded = true;
            }
         }
         if(!bAlreadyAdded){
             noDup[noDupCount++] = list[c]; 
         }
     }
     int[] newUniques = new int[noDupCount];
     for(int i = 0; i < noDupCount; i++){
         newUniques[i] = noDup[i];
         System.out.println(noDup[i]);
     }
     return newUniques;
}