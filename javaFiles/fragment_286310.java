public class MyTest {

    @Mock(name = "solrServer")
    private SolrServer solrServer;

    @InjectMocks
    private MyClass myClassMock;

    @Before
    public void setUp() {
        myClassMock = new MyClass("value you need");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    ....

}