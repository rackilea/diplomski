static void doAction(List<Hunt> list) {
    list.removeIf(h -> h.getTokens().contains("INC") &&
            Arrays.stream(h.getTokens().split(";"))
                    .anyMatch(tag -> tag.contains("INC") && tag.endsWith("N")
                            && !(flag ? h.getPropertyA().equals(anotherObject.getPropertyAValue())
                            : h.getPropertyB().equals(anotherObject.getPropertyBValue()))));
}