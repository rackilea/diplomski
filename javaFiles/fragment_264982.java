public class ShoppingApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>() {{
            add(TestResource.class);
        }};
    }

    @Override
    public Set<Object> getSingletons() {
        return new HashSet<Object>();
    }
}

package ...same package as the real TestResource...
public class TestResource {

}