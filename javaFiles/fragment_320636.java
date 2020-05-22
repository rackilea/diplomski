@RunWith(Parameterized.class)
public class EdiTest {

    @SuppressWarnings("WeakerAccess")
    @Parameterized.Parameter(value = 0)
    public String model;

    @SuppressWarnings("WeakerAccess")
    @Parameterized.Parameter(value = 1)
    public String filename;

    @Parameterized.Parameters(name = "{index}: testEDI({0}, {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"753", "edi753_A.edi"},
                {"753", "edi753_B.edi"},
                {"754", "edi754.edi"},
                {"810", "edi810-withTax.edi"},
                {"810", "edi810-withoutTax.edi"},
        });
    }

    @Before
    public void setUpContext() throws Exception {
        TestContextManager testContextManager = new TestContextManager(getClass());
        testContextManager.prepareTestInstance(this);
    }

    @Test
    public void testEDI() throws IOException {
        String edi = IOUtils.toString(ClassLoader.getSystemResource(filename));
        EdiConverter driver = ediConverterProvider.getConverter(model);

        // your test code here
    }

}