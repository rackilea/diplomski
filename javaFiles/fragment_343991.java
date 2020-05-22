@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class SomeClassTest {

    private Context context;
    private SomeClassTest someClassTest;
    private SharedPreferences sharedPreferences;

    @Before
    public void setup() throws Exception {
        context = Roboelectric.application;
        sharedPreferences = ShadowPreferenceManager.getDefaultSharedPreferences(context);
        someClassTest = new SomeClassTest(context);
    }

    @Test
    public void someClassProduction() {
        when(someClassTest.getEnvironment()).thenReturn("PRODUCTION");
        when(someClassTest.getBaseUrl()).thenReturn("https://www.someUrl.com/v1/");
        assertTrue(someclassTest.getTestUrl().equals("https://www.someurl.com/v1/counts.json")
    }
}