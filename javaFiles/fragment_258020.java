@RunWith(PowerMockRunner.class)
public class StuffTest {

private RegularStuff testObject;

@Before
public void setUp() {
    testObject = PowerMockito.mock(RegularStuff.class, Mockito.CALLS_REAL_METHODS);
    // The reason using CALLS_REAL_METHODS is that we are both testing & mocking same object.
}

// test by mocking public method
@Test
public void testGetAmountOfStuff() {

    PowerMockito.when(testObject.getAmount()).thenReturn(5);

    int result = testObject.getAmountOfStuff();
    Assert.assertEquals(5, result);
}

}