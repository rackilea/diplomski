public class MyAppTest extends ApplicationTestCase<MyApp> {

    public MyAppTest () {
        super(MyApp.class);
    }

    public MyAppTest (Class<MyApp> applicationClass) {
        super(applicationClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }

    public void testMyApp() throws Exception {
        // Retrieves a file in the res/xml folder named test.xml
        XmlPullParser xml = getContext().getResources().getXml(R.xml.test);
        assertNull(xml);
    }
}