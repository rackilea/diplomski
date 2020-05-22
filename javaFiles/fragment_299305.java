public enum LegNo {
    NO_LEG(-1), LEG_ONE(1), LEG_TWO(2);

    private final int value;

    LegNo(int value) {
        this.value = value;
    }

    public static Optional<LegNo> valueOf(int value) {
        return Arrays.stream(values())
            .filter(legNo -> legNo.value == value)
            .findFirst();
    }
}