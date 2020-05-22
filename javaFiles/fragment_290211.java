@RunWith(PowerMockRunner.class)
@PrepareForTest({ AppEntityManager.class}) 
public class ClassUnderTestTest {

  @Mock
  private EntityManager emMock;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void test() {
    PowerMockito.mockStatic(AppEntityManager.class);
    Mockito.when(AppEntityManager.createEntityManager()).thenReturn(emMock);

    String s = ClassUnderTest.methodUnderTest(myParams);
    // assertEquals(prams[i][1], s);
  }

}