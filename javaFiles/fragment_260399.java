public static void moveAll( int x, int y, Relatable... obj) {

    for(Relatable r: obj){
        ((Rectangle)r).move(x, y);
    }

}