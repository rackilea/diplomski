enum MIPS32Instructions {

    MUL("MUL", (v) -> v > 0),
    DIV("DIV", (v) -> v > 1, (v) -> v != 9);
    final String id;
    final Predicate<Integer>[] conditions;

    MIPS32Instructions(String id, Predicate<Integer>... conditions) {
        this.id = id;
        this.conditions = conditions;
    }

    public boolean checkConditions(int v) {
        return Arrays.stream(conditions)
                .allMatch((c) -> c.test(v));
    }

}