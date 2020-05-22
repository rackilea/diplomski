@XmlRootElement( name = "item" )
public class ItemProxy
{
    private String name;
    private int category;
    private int subcategory;

    @XmlElement
    public String getName()
    {
        return name;
    }

    @XmlElement
    public int getCategory()
    {
        return category;
    }

    @XmlElement
    public int getSubcategory()
    {
        return subcategory;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setCategory( int category )
    {
        this.category = category;
    }

    public void setSubcategory( int subcategory )
    {
        this.subcategory = subcategory;
    }
}