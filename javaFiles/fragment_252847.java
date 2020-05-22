public class MyConfig {

    @Autowired
    private Foo foo;

    @Bean
    public Bar bar() {
      Bar bar = new Bar();
      bar.setFoo(foo); // foo is defined in somebeans.xml
      return bar;
    }
}