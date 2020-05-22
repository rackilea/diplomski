public class OrchestratingClassTest {
    @Mock
    private ClassA mockA;

    @Mock
    private ClassB mockB;

    @InjectMocks
    private OrchestratingClass oc;

    @Before
    public void prepare() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConcatenate() {
        when(mockA.do1()).thenReturn("1");
        when(mockB.do2()).thenReturn("2");
        assertEquals("1 2", oc.orchestrate());
    }
}