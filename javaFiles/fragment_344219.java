public enum Critter {
    KITTY(CritterCode.KITTY),
    PUPPY(CritterCode.PUPPY)

    private final String code;

    private Critter(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}