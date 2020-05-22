public class MyBeanTest {

    @Tested
    DirBean tested;

    @Before
    public void recordExpectationsForPostConstruct() {
        new MockUp<DirBean>() {
            @Mock
            void init() {
            }
        }; 
    }

    @Test
    public void testMyDirBeanCall() {
        tested.methodIwantToTest();
    }
}