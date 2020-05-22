@Root(name="parent")
@Convert(ExampleConverter.class)
public class Example
{
    private String text; // Save the text you want to set ('some text' in your code)
    private List<Object> valueUnion;

    // Constructor + getter / setter
}