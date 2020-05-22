for(int i=0;i<=15;i++){
    for(int j=0;j<=15;j++){
        for(int k=0;k<=15;k++){
            for(int l=0;l<=15;l++){
              for(int m=0;m<=15;m++){
                allsolutions[i][j][k][l][m] = i;
                System.out.println("Set index "+ i + " " + j + " " + k + " " + l + " " + m + " equal to " + i);
              }
            }
        }
    }
}