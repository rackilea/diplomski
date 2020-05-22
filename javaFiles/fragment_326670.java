@ExtendWith(MockitoExtension.class)
public class MockTest {

  int a = 1;
  int b = 1;
  int c = 1;

  @Nested
  class InitializedTests{
    @BeforeEach
    void init(TestInfo info) {
        a=5;
        b=10;
        c=15;
    }

    @Test
    void testOne(){
        int expected = 15;
        assertEquals(expected,a+b);
    }

  }

  @Nested
  class StandaloneTests {
    @Test
    void testTwo(){
        int expected = 3;
        assertEquals(expected,a+b+c);
    }
  }
}