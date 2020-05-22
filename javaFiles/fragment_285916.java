public class MyApplication extends ResourceConfig {

    public MyApplication () {
        register(MyRequestContextFilter.class);
        register(MyResource.class);
        packages("com.mycompany.resources");
        ...
    }
}