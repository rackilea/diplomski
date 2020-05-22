int[][][] feld = new int[6][][];
for (int d1 = 0; d1 < feld.length; d1++) { 
    feld[d1] = new int[10][];   // <-- added extra [] here
    for (int d2 = 0; d2 < feld[d1].length; d2++) {
        feld[d1][d2] = new int[7];
    } 
}