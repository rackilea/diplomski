@Value("${library.system.property}")
private String property;

@Bean
public SampleProvider getSampleProvider () {
    return SampleProvider.from(property);
}