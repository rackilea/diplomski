@javax.ws.rs.ApplicationPath("/")
    public class MyApplication extends ResourceConfig {
       public MyApplication() {
           packages("controller");
           register(JacksonFeature.class);
           register(ClientExceptionMapper.class);          
       }
    }