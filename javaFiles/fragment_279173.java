@RunWith(Parameterized.class)
public class MyTest {
    @Parameters
    public static Collection<Object[]> data() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/jeanne/jeanne.xml");
        String dir = ctx.getBean("testFilesDirectory", String.class);

            // write java code to link files in test directory to the array
        return Arrays.asList(new Object[][] { { 1 } });
    }
// rest of test class
}