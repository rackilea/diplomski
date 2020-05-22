int[] wordCountList = new int[arrayCount]; //arrayCount is     just the size of the array of words
 for(int p = 0; p < words.length; p++){
     //int counter = 0;
     for(String needle : words){
        //String currentItem = words[p];    //words is the array of words

         if(words[p].equals(needle)){
           wordCountList[p]++;
         }
     }
 }