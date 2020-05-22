@Root(name = "TestSuite")
public class TestSuite implements TestEntry
{
    @Attribute
    private int change;
    @Attribute(required = false)
    private String name;
    @ElementListUnion({
        @ElementList(inline = true, required = false, type = TestCase.class, name = "TestCase"),
        @ElementList(inline = true, required = false, type = TestSuite.class, name = "TestSuite")
    })
    private List<TestEntry> content;

    // Getter etc.
}