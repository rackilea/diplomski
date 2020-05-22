list[numElements] = value;
        for(int i = 0; i < numElements; i++){
            //May be I should use a nested loop?
            //for(k = 0; k <)
             if(value < list[i]){
                 for(int j= numElements-1; j>=i; j--){
                      list[j+1]= list[j];
                  }
                  list[i] = value;
                  break;
            }
        }
        numElements++;