while(x.hasNext()){
         for(int i = 0; i < n; i++){
             String line = x.next();
             for(int j = 0; j < n; j++){
                 array[i][j] = line.charAt(j) - '0';
                 System.out.printf("%d", array[i][j]);
             }
            System.out.println();
         }
    }