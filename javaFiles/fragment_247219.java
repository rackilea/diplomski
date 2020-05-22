@RunWith(PowerMockRunner.class)
@PrepareForTest(AttributeHelper.class)
public class PojoTest {
    static  PojoValidator validator;

    @BeforeClass
    public static void setUpClass(){
        validator = new PojoValidator();
        validator.addRule(new GetterMustExistRule());
        validator.addRule(new SetterMustExistRule());
        validator.addTester(new GetterTester());
        validator.addTester(new SetterTester());
    }

    @Before
    public void setUp(){
        PowerMockito.replace(method(AttributeHelper.class, "formattedFieldName")).with(method(PojoTest.class, "formattedFieldName"));
    }

    @Test
    public void testPojo() throws Exception {
        for (PojoClass cls: PojoClassFactory.getPojoClasses("mypackage")){
               validator.runValidation(cls);
        }
    }

    private static final List<String> fieldPrefixes = new LinkedList<String>();

    private static String formattedFieldName(final String fieldName) {
        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
    }
}