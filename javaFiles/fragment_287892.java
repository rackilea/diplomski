public class frontend {

    private static final Logger log = Logger.getLogger(frontend.class.getName());
    private static Options opts = new Options();

    public frontend() {
        System.out.println("Made a new front end");
    }

    public static Options getOptions() {
        if (opts == null) {
            System.out.println("Opts was null");
        } else {
            System.out.println("Opts is not null");
        }
        return opts;

    }

    public static void main(String[] args) {
        frontend fe = new frontend();
        init();
    }

    private static void init() {
        String n = System.getProperty("java.util.logging.config.class");
        if (n != null) {
            try { //LogManager uses the system class loader.
                Class<?> k = Class.forName(n, false,
                        ClassLoader.getSystemClassLoader());
                k.newInstance();
            } catch (ReflectiveOperationException | LinkageError ignore) {
                ignore.printStackTrace();
            }
        }
    }
}