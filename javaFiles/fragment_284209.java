@SpringBootApplication
public class ParameterClassConfigurator
{
    @Value("${my.first.property}") String property1;
    @Value("${my.second.property}") String property2;

    @Bean
    public ParameterClass parameterClass()
    {
        ParameterClass params = new ParameterClass(property1, property2);
        return params;
    }
}