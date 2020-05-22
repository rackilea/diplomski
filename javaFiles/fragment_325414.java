private String find(int minLength) {
    for (String string : strings) {
        if (string.length() >= minLength) {
            return string;
        }
    }
    throw new SomeExceptionIndicatingTheProblem("...");
}