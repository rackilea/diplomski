enum AuthorizationLevel {

    FULL(1), HALF(2), NONE(3);

    private final int level;

    private AuthorizationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
};