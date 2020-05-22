public static int[] searchTemp(int[] array, int key) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
                if(array[i] == key)
                    count++;
        }
        int[] indices = new int[count];
        for(int j = 0; j < indices.length; j++) {
            for(int i = 0; i < array.length; i++) {
                if(array[i] == key) {
                    if(j > 0 && indices[j - 1] == i){
                        continue;
                    }
                    else {
                        indices[j] = i;
                        break;
                    }                   
                }                    
            }
        }
        return indices;
   }