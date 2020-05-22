@Configuration
public class Conf {

    @Bean
    public MyObject myObject() {
        return MyStaticFactory.getObject()
    }

}