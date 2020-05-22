class BaseType {
    String x;
    int y;
    public BaseType (String x, int y) {
        this.x=x;
        this.y=y;
    }
    String getX () {return x;}
    int getY () { return y;}
}

class SubType extends BaseType {
    String z;

    public SubType (String x, int y,String z) {
        super(x,y);
        this.z=z;
    }
    String getZ () {return z;}
}