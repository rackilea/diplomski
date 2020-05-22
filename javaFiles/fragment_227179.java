while (inFile.hasNext()){
        for (int i = 0; i < 20; i++){
            for (int j = 0; j<5; j++){
                if (j == 2) {
                     StringBuilder temp = new StringBuilder(inFile.next());

                     while(!inFile.hasNextInt()){
                         temp.append(" " + inFile.next());
                     }
                     cities[i][j]=temp.toString();
                     continue;
                }
                cities[i][j]=inFile.next();
            }
        }
    }