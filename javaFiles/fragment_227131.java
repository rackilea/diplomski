@Root(name = "howToRenderEmptyTag")
public class HowToRenderEmptyTag
{
    @Element(name = "emptyString", required = false)
    @Convert(value = EmptyElementConverter.class) // Set the converter for this element
    private String nullString;


    // ...
}