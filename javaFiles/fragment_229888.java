@Configuration
@ImportResource({
        "classpath:applicationContext-common.xml",
        "classpath:app-servlet.xml"
})
static class TestConfig {
    static class Bar extends Foo {
        //some stuff overridden here
    }
    private Bar myTestBar = new Bar();
    @Bean(name="x.y.z.Foo")
    public Foo getFoo() {
       return myTestBar;
    }
}