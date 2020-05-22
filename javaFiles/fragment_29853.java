public enum Constants {
    DEBUG(true),
    PRINT_VARS(false);

    private boolean enabled;

    private Constants(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}