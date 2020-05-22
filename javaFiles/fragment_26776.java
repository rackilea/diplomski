@Configuration
public class ClassAConfig {

    @Autowired
    @Qualifier("c1")
    private C c1;

    @Autowired
    @Qualifier("c2")
    private C c2;

    ...

    @Bean(name = "a1")
    public A createA1() {
        ...
    }

    @Bean(name = "a2")
   public A createA2() {
       ...
   }