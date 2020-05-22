int n = 3;
    int[][] feld = new int[2*n][2*n];
    int c = 0;

    while(c<n) {
        for(int i = c; i < 2*n-c; i++) {
            feld[c][i] = c+1;
            feld[i][c] = c+1;
            feld[2*n-c-1][i] = c+1;
            feld[i][2*n-c-1] = c+1;
        }
        c++;
    }
    for (int i = 0; i < feld.length; i++) { //print the matrix
        for (int j = 0; j < feld[i].length; j++) {
            System.out.print(feld[i][j] + " ");
        }
        System.out.println();
    }