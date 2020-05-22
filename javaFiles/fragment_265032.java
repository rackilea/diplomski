@Configuration
public class MyConfiguration {

@Bean
public ConverterRegistry initConverter(ConverterRegistry registry) {
    registry.addConverterFactory(new MyStringToEnumConverterFactory());
    return registry;
}
}