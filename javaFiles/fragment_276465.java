Constructor(){
    int y1 = 0;
    int y2 = 1;

    for (int x = 0; x < 10; x++){
        y1 = Calc(y1, x);
        y2 = Calc(y2, x);
    }
}