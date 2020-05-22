public int getOverM(int m){
        for(int j = 0; j < A.length; j++){
              if(m <= A[j]){            //if the current element is greater than or equal to m then return the index .
                 return j;        
              }
        } 
        return -1; // return -1 if the loop ends by not finding any element which is greater than or equal to m
    }