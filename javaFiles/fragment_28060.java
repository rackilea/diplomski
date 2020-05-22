@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock(name = "b2")
    private B b2;

    @Mock(name = "b3")
    private B b3;

    @InjectMocks
    private A a;

    @Test
    public void testInjection() {
        System.out.println(this.a);
    }

    static class A {

        private B b1;

        private B b2;

        private B b3;
    }

    interface B {
    }
}