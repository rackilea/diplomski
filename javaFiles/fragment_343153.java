class enum PermissionLevel {
    MEMBER(0),
    MODERATOR(1)

    private final int level;

    PermissionLevel(int level) {
        this.level = level; 
    }

    public int getLevel() {
        return level;
    }
}