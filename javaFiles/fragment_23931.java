@Root(name = "Test")
public class TestCase implements TestEntry
{
    @Attribute(required = false)
    private int fail;
    @Attribute
    private String name;

    // Getter etc.
}