@RunWith(PowerMockRunner.class)
@PrepareForTest(TestME.class)
public class JunitTest {

    @Before
    public void setUp(){
        B b = PowerMockito.mock(B.class);
        PowerMockito.spy(TestME.class);
        PowerMockito.when(TestME.getInstanceOfB()).thenReturn(b);
    }

   @Test
    public void testMe(){
        Assert.assertEquals(2, TestME.testme("xyz", "omg"));
    }
}