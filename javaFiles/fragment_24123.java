public enum TypeSignsEnum {

    NEGATIVE(45, 17, 11, 66, 31, 56, 85, 14, 15, 91, 30),
    POSITIVE(58, 26, 97, 12, 89, 18, 22, 19, 20, 16, 25, 92, 10, 14, 24, 60, 65, 79, 57, 27, 23, 96),
    DEFAULT();

    private final HashSet<Integer> values;

    TypeSignsEnum(Integer ...values) {
        this.values = new HashSet<>(Arrays.asList(values));
    }

    public static TypeSignsEnum fromValue(int value) {
        for (TypeSignsEnum e : TypeSignsEnum.values()) {
            if (e.values.contains(value)) {
                return e;
            }
        }
        return DEFAULT;
    }

}