@Bean
public Jackson2ObjectMapperBuilderCustomizer init() {
    return new Jackson2ObjectMapperBuilderCustomizer() {
        @Override
        public void customize(Jackson2ObjectMapperBuilder builder) {
            builder.timeZone(TimeZone.getDefault());
        }
    };
}