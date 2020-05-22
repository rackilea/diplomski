static void doAction(List<Hunt> list) {
    list.removeIf(MyClass::isCorrect);
}

private static boolean isCorrect(Hunt h) {
    return h.getTokens().contains("INC") &&
            Arrays.stream(h.getTokens().split(";"))
                    .filter(tag -> tag.contains("INC"))
                    .map(tag -> tag.substring(tag.length() - 1))
                    .filter("N"::equals)
                    .anyMatch(v ->
                            (flag && !h.getPropertyA().equals(anotherObject.getPropertyAValue())) ||
                            (!flag && !h.getPropertyB().equals(anotherObject.getPropertyBValue())));
}