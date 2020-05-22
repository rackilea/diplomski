public interface Relatable {
    public static void moveAll( int x, int y, Relatable... obj) {

        for(Relatable r: obj){
            r.move(x, y);
        }

    }

    public void move(int x, int y);

}