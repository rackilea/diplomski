enum NAMES {
    ONE, TWO, THREE, FOUR, FIVE;

    public static NAMES fetchValue(String constant) {
        NAMES name = null;
        for (NAMES num : EnumSet.allOf(NAMES.class)) {
            if (num.name().equals(constant)) {
                name = NAMES.valueOf(constant);
            }
        }
        return name;
    }
}