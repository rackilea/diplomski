public class ServerConfig extends Application {

    private static final Set<Class<?>> classes
            = new HashSet<>();

    static {
        //register your resources
        classes.add(Test.class);
        //register message body writer
        classes.add(IntWriter.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}