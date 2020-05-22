for(int i = 0; i < rowCount; i++){
   for(int j = 0; j < colCount; j++){
     for(int k = 0; k < colCount; k++){
       if(differencearray[i][k]>differencearray[i][k+1]){
            int temp = differencearray[i][k];
            differencearray[i][k] = differencearray[i][k+1];
            differencearray[i][k+1] = temp;
       }

     }
   }
 }