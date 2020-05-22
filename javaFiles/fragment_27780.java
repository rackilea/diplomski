public static Operation get(String input) {
    if(input.equals("+")) {
        return ADD;
    }
    if(input.equals("-")) {
        return SUBTRACT;
    }
    throw new IllegalArgumentException();
}