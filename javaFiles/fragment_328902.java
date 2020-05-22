int[]feld = new int[30];
    feld[0]=0;
    feld[1]=1;

    for(int i=2; i<30; i++) {
        feld[i]=feld[i-2]+feld[i-1];
    }

    tvOutput.setText(Arrays.toString(feld));