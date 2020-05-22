private void drawGrid(){

   GLine[] glines = new GLine[3];

    for(int i = 0; i<3; i++){
        GLine line = new GLine(0,0,21*i,211*i);
        glines [i] = line;
    }
}