public class Pytaguras {
    private double x, y, x1 ,y1 ;
    public void setDouble(double _x, double _y, double _x1, double _y1) {
        _x=x;
        _y=y;
        _x1=x1;
        _y1=y1;
    }

    public static double calculate(double _x , double _y , double _x1 , double _y1 ) {
        return Math.sqrt((_x-_y)*(_x-_y)+(_x1-_y1)*(_x1-_y1));
    }

    public String toString() {
        return "Distance is " + Math.sqrt((x - y)*(x -y)+(x1 - y1)*(x1 - y1));
    }
}