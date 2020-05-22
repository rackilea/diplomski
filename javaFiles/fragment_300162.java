@RunWith(MockitoJUnitRunner.class)
public class DummyTest {
  @Mock
  private HelperClass helperclass;

  @InjectMocks
  private Dummy dummy;

  @Before
  public void start() 
  {
    System.out.println("In @Before!");
    Interface1 mockInterface = mock(Interface1.class);
    when(helperclass.somefunction()).thenReturn(mockInterface);
  }

  @Test
  public void test()
  {
    System.out.println("In @Test!");
  }

  public static class Dummy {
    public final Interface1 interface1;
    public final HelperClass helperclass;

   @Inject
   Dummy(HelperClass helperclass) 
   {
     System.out.println("In dummy constructor!");
        this.interface1 = helperclass.somefunction();
        this.helperclass = helperclass;
   }
 }

  private static class HelperClass {
    Interface1 somefunction() {
      return new Interface1() {};
    }
  }

  private static interface Interface1 {

  }
}