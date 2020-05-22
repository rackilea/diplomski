for(int j=0; j<newArray.length; j++) {
      for(int k=0; k<newArray.length; k++) {
         if(newArray[k] > newArray[j]) { 
            //the swap logic:
            int t = newArray[k];
            newArray[k] = newArray[j];
            newArray[j] = t;
         }
      }
   }