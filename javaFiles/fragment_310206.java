@RunWith(PowerMockRunner.class)
@PrepareForTest(ServiceLoader.class)
public class PowerMockingStaticTest
{
    @Mock
    private ServiceLoader mockServiceLoader;

    @Before
    public void setUp()
    {
        PowerMockito.mockStatic(ServiceLoader.class);
        Mockito.when(ServiceLoader.load(Mockito.any(Class.class))).thenReturn(mockServiceLoader);
    }

    @Test
    public void test()
    {
        Assert.assertEquals(mockServiceLoader, ServiceLoader.load(Object.class));
    }
}