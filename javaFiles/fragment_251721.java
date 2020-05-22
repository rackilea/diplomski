...
    for (int i = 0; i < alpha.length; i++){
        for (int j = 0; j < alpha[i].length; j++){
            System.out.print(alpha [i][j] + " ");  
        }
        System.out.println();
    }

    for (int r = alpha.length-1; r >= 0; r--){
        for (int s = alpha[r].length-1; s >=0; s--){
            System.out.print(alpha[r][s]+ " ");
        }
        System.out.println();
    }
...