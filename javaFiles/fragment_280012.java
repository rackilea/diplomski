public class MyServiceTest {
    private MyServiceImpl objectUnderTest = new MyServiceImpl();
    private PersonDao fakePersonDao;
    @Before
    public void setUp() {
        fakePersonDao = new FakePersonDao(); // or define it using Mockito
        objectUnderTest.setPersonDao(fakePersonDao);
    }
}