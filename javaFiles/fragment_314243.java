class SpockSettings {
    public static final boolean SKIP_SLOW_TESTS = ignoreLongRunning();

    public static boolean ignoreLongRunning() {
        def properties = new Properties()
        def inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("spock.properties")
        properties.load(inputStream)
        inputStream.close()
        //properties.list(System.out)
        Boolean.valueOf(properties["spock.skip.slow"])
    }
}