public class MyRestConfig extends ResourceConfig {

    public RestConfig() {

        // your configs...

        packages("com.yourpackage.rest");

        // ...

        // handle @MyCustomAnnotation annotations
        register(MyFilterDynamicFeature.class);

        // ...    
    }

}