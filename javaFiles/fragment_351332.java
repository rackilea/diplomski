public class Pixel implements Comparable{

    int x,y;

    public Pixel(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object arg0) {
        Pixel p = (Pixel) arg0;
        if(p.x == x && p.y == y)
            return 0;
        return -1;
    }

}