public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder
                .sources(Application.class)
                .properties(getProperties());
    }

    public static void main(String[] args) {

        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Application.class)
                .sources(Application.class)
                .properties(getProperties())
                .run(args);
    }

   static Properties getProperties() {
      Properties props = new Properties();
      props.put("spring.config.location", "classpath:myapp1/");
      return props;
   }
}