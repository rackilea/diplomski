@Configuration
@Profile("dev")
public class BeanConfiguration {

    @Bean
    @Scope(scopeName = SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

}