public enum Permission {
    /* I like to have binary literals in place of bit fields,
     * but any notation will work */
    BUILD   (0b0001),
    BREAK   (0b0010),
    INTERACT(0b0100);

    private final int index;

    private Permission(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}