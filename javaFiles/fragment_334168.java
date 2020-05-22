@Configuration
@Profile("!test")
public class MyRealConfigClass {

    @Bean
    public YetAnotherClass yetAnotherClass() {
        return new YetAnotherClass();
    }
}

@Configuration
@Profile("test")
public class MockObjectsConfig {

    @Bean
    public YetAnotherClass yetAnotherClass() {
        Mockito.mock(YetAnotherClass.class); // and add any thenReturns, answers, etc. here
    }    
}