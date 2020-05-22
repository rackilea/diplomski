public class MyClass
{
    private static final URL RESOURCE_URL;

    static {
        RESOURCE_URL = MyClass.class.getResource("/my/resource");
        if (RESOURCE_URL == null)
            throw new ExceptionInInitializerError("/my/resource not found");
    }
    // bla bla...

    // code to load from the resource:

    try (
        final InputStream in = RESOURCE_URL.openStream();
        // others, as needed
    ) {
        // work here
    }