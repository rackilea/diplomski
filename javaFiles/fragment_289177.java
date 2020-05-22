@RunWith(SpringJunit4TestRunner.class)
@ContextConfiguration(location={})
public class AbstractTestCase
{

}


public class ConcreteTestCase extends AbstractTestCase
{
    @Before
    public void setUp()
    {
        // Some set up before each test.
    }

    @Test
    public void test1()
    {
        // Some test
    }

    @Test
    public void test2()
    {
        // Some other test
    }

    @After
    public void tearDown()
    {
        // Some tear down process after each test.
    }

}