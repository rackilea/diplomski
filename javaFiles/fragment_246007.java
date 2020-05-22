HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
messageConverters.add(stringHttpMessageConverternew);
messageConverters.add(formHttpMessageConverter);
restTemplate.setMessageConverters(messageConverters);