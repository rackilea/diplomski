public enum Operator implements BinaryOperator<Double> {
    plus("+") {
        public Double apply(Double v1, Double v2) {
            return v1 + v2;
        }
    },
    minus("-") {
        public Double apply(Double v1, Double v2) {
            return v1 - v2;
        }
    };

    private final String text;

    Operator(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Operator from(String str) {
        return Arrays.stream(values()).filter(o -> o.text.equals(str)).findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}