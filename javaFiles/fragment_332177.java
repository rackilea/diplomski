@RunWith(Parameterized.class)
public class GraphSearcherTest
{
    private GraphSearcher testedSearcher;

    public GraphSearcherTest(GraphSearcher searcher)
    {
        this.testedSearcher = searcher;
    }

    @Parameters
    public static Collection<Object[]> getParameters()
    {
        return Arrays.asList(new Object[][] {
                { new GraphSearcherImpl1() },
                { new GraphSearcherImpl2() }
        });
    }

    @Test
    public void testGraphSearcher()
    {
        // execute the test
        testedSearcher.search();

        // make some assertions
    }
}