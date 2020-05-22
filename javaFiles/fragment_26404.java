public class LicenseChecker {

    @Autowired
    private ApplicationContext ctx;

    public void check() {
        if (!exist || !valid) {
            ((ConfigurableApplicationContext) ctx).close();
            System.exit(1);
        }
    }

}