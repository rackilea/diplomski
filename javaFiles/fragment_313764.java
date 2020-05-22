public enum Functionality {
    FUNCTION_1(true),
    FUNCTION_2,
    FUNCTION_3(true);

    private final boolean restricted;

    Functionality() {
       this(false);
    }

    Functionality(boolean restricted) {
        this.restricted = restricted;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public boolean isUsable() {
        if (!restricted) {
            return true;
        } else {
            return SystemConfiguration.isDevelopmentSystem();
        }
    }
}