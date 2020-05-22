public class frontend {

    private static volatile Logger log;
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
        log = Logger.getLogger(frontend.class.getName());
    }
}