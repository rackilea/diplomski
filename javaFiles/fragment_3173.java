public class CalculatorTest {

    @Before
    public void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(new LocalDate(2016,1,1).toDateTimeAtStartOfDay().getMillis());
    }

    @After
    public void tearDown() {
        DateTimeUtils.setCurrentMillisSystem();
    }
}