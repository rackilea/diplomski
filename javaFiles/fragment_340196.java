for(int i = 0; i < list.length - 1; i++) {
       for(int j = 0; j < list.length - i -1; j++){             
            if(list[j] > list[j+1]){
                swap = list[j];
                list[j] = list[j+1];
                list[j+1] = swap;

            }
            System.out.println(Arrays.toString(list));
        }
     }