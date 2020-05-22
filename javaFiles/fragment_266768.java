public class LogManagerTest {

    public static void main(String[] arg) throws IOException {
        read(LogManager.getLogManager(), create());
        Handler h = new ConsoleHandler();
        System.out.println(h.getLevel());
        h.close();
    }

    private static Properties create() {
        Properties props = new Properties();
        props.setProperty("java.util.logging.ConsoleHandler.level", 
                "FINE");
        return props;
    }

    private static void read(LogManager manager, Properties props) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream(512);
        props.store(out, "No comment");
        manager.readConfiguration(new ByteArrayInputStream(out.toByteArray()));
    }
}