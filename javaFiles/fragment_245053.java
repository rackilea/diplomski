HashMap<String, Object> props = new HashMap<>();
props.put("server.port", 9999);

new SpringApplicationBuilder()
  .sources(SampleController.class)                
  .properties(props)
  .run(args);