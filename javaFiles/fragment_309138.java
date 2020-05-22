public enum Browser {


    CHROME("Chrome"),
    FIREFOX("FireFox"),
    IE("IE", "MSIE", "Microsoft Internet Exporer"),
    ;

    private String[] aliases;

    private static Map<String, Browser> browsers = new HashMap<>();
    static {
        for (Browser b : Browser.values()) {
            for (String alias : b.aliases) {
                browsers.put(alias, b);
            }
        }
    }

    private Browser(String ... aliases) {
        this.aliases = aliases;
    }

    public static Browser valueOfByAlias(String alias) {
        Browser b = browsers.get(alias);
        if (b == null) {
            throw new IllegalArgumentException(
                    "No enum alias " + Browser.class.getCanonicalName() + "." + alias);
        }
        return b;
    }
}