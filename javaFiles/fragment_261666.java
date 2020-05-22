@Priority(Priorities.AUTHORIZATION - 1)
public class MyFilter implements ContainerRequestFilter {

    private final Class<?> _class;
    private final Method method;
    private MyCustomAnnotation classAnnotation;
    private MyCustomAnnotation methodAnnotation;

    public MyFilter(Class<?> _class, Method method) {

        this._class = _class;
        this.method = method;

        this.classAnnotation = _class.getAnnotation(MyCustomAnnotation.class);
        this.methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);

    }

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // your code goes here!

        // based on classAnnotation and/or methodAnnotation, 
        // add whatever you want to the requestContext

    }
}