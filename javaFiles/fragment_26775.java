@Configuration
public class ClassCConfig {

    @Bean(name = "c1")
    public C createrC1() {
        returns new C();
    }

    @Bean(name = "c2")
    public C createrC2() {
        ...
    }

    @Bean(name = "c3")
    public C createrC3() {
        ...
    }

    ....