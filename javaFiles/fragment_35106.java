@Root(name = "book")
public class Book
{
    @Attribute
    private String num;
    @Element(required = false)
    private Chapter chapter;

    // ...
}