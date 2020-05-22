public class Spot {
    public String name;
    public String address;
    public int type;
    public double duration;
    public double lat;
    public double lng;
    public boolean isStar;
}

public class Restaurant extends Spot {
    /* the rest is inherited */
    public int contact;
}