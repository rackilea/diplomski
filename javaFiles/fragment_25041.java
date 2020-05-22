@Configuration
public class MvcConfig {    
    @Configuration
    @EnableWebMvc
    public class MessageConvertersConfiguration implements WebMvcConfigurer {
        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
        }

        @Bean
        public ObjectMapper objectMapper() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
            SimpleModule localDateModule = new SimpleModule();
            localDateModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
            localDateModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModules(localDateModule);

            return mapper;
        }
    }
}