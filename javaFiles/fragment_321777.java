@RunWith(SpringJUnit4ClassRunner.class)
public class FooTest {
  @Test
  public void testBazCalledFromBar(){
    Foo fooMock = Mockito.mock(Foo.class);
    doCallRealMethod().when(fooMock).bar(anyString());
    fooMock.bar("callBaz");

    Mockito.verify(fooMock).baz("callBaz");
  }
}