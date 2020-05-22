@Configuration
public class Config2 {
    @Primary @Bean public Greeter primary(@Qualifier("obiWan") Greeter g) { 
        return g; 
    }
}