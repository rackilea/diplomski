@RunWith(MockitoJUnitRunner.class)
class ATest{
  private B b = mock(B.class);
  @Spy
  private List<B> bList = new ArrayList<B>() {{ add(b); }};

  @InjectMocks
  private C c = new C();

  @Test
  public void test(){
    c.methodIWantToTest();
    // verify results
  }
}