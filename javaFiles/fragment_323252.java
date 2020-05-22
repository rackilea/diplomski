@Configuration
public class FelineConfig {

    @Bean
    public Feline cat() {
        return Feline.CAT;
    }

    @Bean
    public Feline lynx() {
        return Feline.LYNX;
    }

}