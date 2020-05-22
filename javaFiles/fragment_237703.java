@RunWith(MockitoJUnitRunner.class)
public class ATest {

    A a;

    @Mock
    B b;

    @Mock
    C c;

    @Test
    public void test() {
        a=new A(b, c);
        A spyA=Mockito.spy(a);

        doReturn(20).when(spyA).method2();

        spyA.method();
    }
}