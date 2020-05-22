@RunWith(PowerMockRunner.class)
@PrepareForTest(RegularStuff.class)
public class StuffTest {

private RegularStuff testObject;

@Before
public void setUp() {
    testObject = PowerMockito.mock(RegularStuff.class, Mockito.CALLS_REAL_METHODS);
    // reason using CALLS_REAL_METHODS, we are both testing & mocking same object.
}

// test by mocking private method
@Test
public void testByMockingPrivateMethod() throws Exception{

    PowerMockito.doReturn(5).when(testObject , "getAmount" );
    int result = testObject.getAmountOfStuff();
    Assert.assertEquals(5, result);
 }
}