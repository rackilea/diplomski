public static Label[][] initWelt() {

    Label[][] welt = new Label[DIM1][DIM2];

    for(int i = 0; i < DIM1; i++){   //populate the array
        for(int j = 0; j < DIM2; j++){
            welt[i][j] = new Label();
        }
    }

    for (int x = 0; x < DIM1; x++) {
        for (int y = 0; y < DIM2; y++) {
            if (Math.random() > 0.4) {
                welt[x][y].setText("X");
            }
            else{
                welt[x][y].setText(" ");
            }
        }
    }
    return welt;
}