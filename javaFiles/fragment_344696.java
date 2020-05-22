@RunWith(MockitoJUnitRunner.class)
public class SomeOtherBeanTest {
    @Mock
    private SomeBean someBean;

    @InjectMocks
    private SomeOtherBean someOhterBean;

    @Before
    public void setUp() {
        Mockito.when(someBean.getText()).thenReturn("Overwritten!");
    }

    @Test
    public void testGetText() throws Exception {
        assertEquals("Overwritten!", someOhterBean.getText());
    }
}