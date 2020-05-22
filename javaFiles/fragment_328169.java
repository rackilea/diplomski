@Element
public class ItemAttributes {
    @Element(inline=true, type=String.class, name="Author")
    public List<String> authors;
...
}