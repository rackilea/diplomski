@ApplicationPath("/")
public class MyApplication extends ResourceConfig {
       public MyApplication() {
          registerClasses(UsersResource.class);
          register(new JettisonFeature());
       }
}