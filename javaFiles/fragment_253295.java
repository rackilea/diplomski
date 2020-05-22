public class Coordinates{
    (...)

    private int x;
    private int y;


    @XmlAttribute(name="x")
    public int getX() {
        return x;
    }

    @XmlAttribute(name="y")
    public int getY() {
        return y;
    } 


}