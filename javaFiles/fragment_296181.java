MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// support "text/plain"
converter.setSupportedMediaTypes(Arrays.asList(TEXT_PLAIN, APPLICATION_JSON));

RestTemplate template = new RestTemplate();
template.getMessageConverters().add(converter);

// It's ok now
MyResult result = tmp.postForObject("http://url:8080/api", 
            new MyRequest("param value"), MyResult.class);