@Root(name = "bible")
public class Bible
{
    @Attribute
    private String name;
    @Attribute
    private String abbrev;
    @Element(required = false)
    private Book book;

    // ...
}