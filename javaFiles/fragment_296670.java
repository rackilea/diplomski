public class YourClass {

    private static final Logger LOG = LoggerFactory.getLogger(YourClass.class);

    public String index(Model model) {
        LOG.debug("User landed on homepage!");
        return "register";
    }

}