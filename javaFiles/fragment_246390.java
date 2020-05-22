class MyClass {
    private static Logger logger = LogManager.getLogger(MyClass.class);

    public void someMethod() {
        // use printf here to precisely control the number of digits displayed
        logger.printf(Level.INFO, "pi: %.5f", Math.PI);
    }
}