@Configuration
@Profile("default")
public class TypeAConfig {
    @Bean
    public Type getType() {
        return new TypeA();
    }
}

@Configuration
@Profile("otherProfile")
public class TypeBConfig() {
    @Bean
    public Type getType() {
        return new TypeB();
    }
}

@Configuration
public class SysConfig {
    @Autowired
    Type type;       

    @Bean Type getType() {
        return type;
    }
}