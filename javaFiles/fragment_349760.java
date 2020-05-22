public class Attributes {

    // 'name' and 'text' occurs only once.
    public String name;

    public String text;

    public Size size;

    // The other attributes

    // color can occur multiple times.
    @XStreamImplicit
    public int color;

}