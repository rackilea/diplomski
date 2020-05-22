public static void main(String[] args) throws IOException {
    Weld weld = new Weld();
    WeldContainer container = weld.initialize();
    Application application = container.instance().select(Application.class).get();
    application.run();
    weld.shutdown();
}