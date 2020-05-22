@Configuration
class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addFormatters(final FormatterRegistry registry) {
        ApplicationConversionService.configure(registry);
    }
}