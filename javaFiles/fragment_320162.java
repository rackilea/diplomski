public class TestRunner {
    public static void main(String[] args) {
        // Add parameter to XmlClass
        Map<String, String> testClassParameters = new HashMap<>();
        testClassParameters.put("classParam1", "valueOfClassParam1");
        testClassParameters.put("day", "Friday");

        TestClass testClass = new TestClass();
        testClass.setParameters(testClassParameters);
        testClass.setClass(TestClass.class);    

        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        // Add parameter to XmlTest
        test.addParameter("testParam1", "clock");
        test.setXmlClasses(Arrays.asList(testClass)) ;

        TestNG tng = new TestNG();
        tng.setXmlSuites(Arrays.asList(suite));    
        tng.run();
    }
}

public class TestClass {

    @Parameters({ "day", "testParam1", "classParam1" })
    @Test
    public void test1(String day, String testParam1, String classParam1) {
        System.out.println("Day: " + day);
        System.out.println("testParam1: " + testParam1);
        System.out.println("classParam1: " + classParam1);
    }
}