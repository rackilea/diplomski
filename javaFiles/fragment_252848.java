public class MyConfig {
    @Bean
    @Autowired
    public Bar bar(Foo foo) {
        Bar bar = new Bar();
        bar.setFoo(foo); // foo is defined in somebeans.xml
        return bar;
    }
}