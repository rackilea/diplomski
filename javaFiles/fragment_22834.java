@Override
public void beforeTestClass(TestContext testContext) throws Exception {
    testContext.getApplicationContext()
            .getAutowireCapableBeanFactory()
            .autowireBean(this);
    // your code that uses autowired fields
}