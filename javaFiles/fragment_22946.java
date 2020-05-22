public class MyRunner extends SpringJUnit4ClassRunner {

    public MyRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
        System.setProperty("sample.property", "hello world!");
    }

}