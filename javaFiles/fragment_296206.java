@Configuration
@EnableAutoConfiguration(exclude=ActiveMQConnectionFactoryConfiguration.class)
//the rest of your annotations
public class AppConfig {

    //declare whatever other beans you need
}