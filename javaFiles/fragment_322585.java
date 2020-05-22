@FunctionalInterface
public interface VerificationStrategy {
    void verify(Foo foo) throws Exception;
}

@Configuration
public class VerificationConfiguration {
    @Bean
    public VerificationStrategy strategy1() {
        return (foo) -> {System.out.println(foo);};
    }

    @Bean
    public VerificationStrategy strategy2() {
        return (foo) -> {System.out.println(foo);};
    }
}    

@Component
public class B {
    @Autowired
    public B(@Qualifier("strategy1") VerificationStrategy a) {}
}

@Component
public class C {
    @Autowired
    public C(@Qualifier("strategy2") VerificationStrategy a) {}
}