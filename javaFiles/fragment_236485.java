for (int i = set.length-1; i >= 0; i --) {   

        for (int j = 0; j < i; j++) { 

            if (set[j] > set[j + 1]) {   
                 int aux = set[j];        
                 set[j] = set[j + 1];  
                 set[j + 1] = aux;        
            }           
        }       
    }