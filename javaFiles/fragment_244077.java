//either autowire
   @Value("classpath:idsclient.properties")
   private Resource idsclientResource; 


   //or construct manually
   ClassPathResource idsclientResource = new ClassPathResource("idsclient.properties");

   ...

   IdSClientConfigurationImpl config = new IdSClientConfigurationImpl(idsclientResource.getFile().getPath());