@Root(name = "Entity")
public class FooEntity
{
    @Attribute(name = "type")
    private String type;
    @Element(name = "Price")
    private int price;

    /*
     * NOTE: A default ctor is required - visibile doesn't matter
     */

    @Override
    public String toString()
    {
        return "FooEntity{" + "price=" + price + '}';
    }
}