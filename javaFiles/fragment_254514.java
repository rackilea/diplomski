class Foo {

    static {
        try (FileInputStream fis = new FileInputStream("C:\\path\\to\\myApp.log.properties")) {
            LogManager.getLogManager().readConfiguration(fis);
        } catch (IOException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    static final Logger logger = Logger.getLogger(Foo.class.getName());

    public static void main(String[] args) throws IOException {
        logger.log(Level.INFO, "Msg message");

        Bar obj = new Bar();

        obj.doSth();
    }
}