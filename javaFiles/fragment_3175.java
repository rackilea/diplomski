public class CalculatorTest {

    @Before
    public void setUp() {
       appClock = Clock.fixed(LocalDate(2016,1,1).toDateTimeAtStartOfDay(), ZoneId.systemDefault());
    }

    @After
    public void tearDown() {
       appClock = Clock.systemDefaultZone();
    }
}