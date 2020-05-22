@Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
       MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
       ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
          objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, true);
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          objectMapper.setDateFormat(new SimpleDateFormat("dd MMM yyyy hh:mm:ss a"));
      jsonConverter.setObjectMapper(objectMapper);

      return jsonConverter;
     }