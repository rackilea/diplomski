public class BTest {
    private List<C> cList;
    @Mock
    private C c;

    @InjectMocks
    private B b;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cList = new ArrayList<>();
        cList.add(c);
    }

    @Test
    public void testCollectC() {
        Mockito.when(c.getX()).thenReturn(5);
        Mockito.when(c.getY()).thenReturn("Hello There");
        b.collectC(cList);
    }
}