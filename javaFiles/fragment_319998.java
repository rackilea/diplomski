@Root(name = "Entity")
public class BarEntity
{
    @Attribute(name = "type")
    private String type;
    @Element(name = "URL")
    private String url;

    /*
     * NOTE: A default ctor is required - visibile doesn't matter
     */

    @Override
    public String toString()
    {
        return "BarEntity{" + "url=" + url + '}';
    } 
}