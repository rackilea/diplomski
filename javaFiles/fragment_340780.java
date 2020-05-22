RestTemplate restTemplate = new RestTemplate();
 for (HttpMessageConverter converter : restTemplate.getMessageConverters) {
     if (converter instanceof StringHttpMessageConverter) {
         ((StringHttpMessageConverter) converter).setWriteAcceptCharset(false);
     }
 }