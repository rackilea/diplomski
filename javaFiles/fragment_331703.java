UnaryOperator<TextFormatter.Change> filterBoolean = (TextFormatter.Change t) -> {
    String testText = t.getControlNewText().toLowerCase();
    if ("truefalse".contains(testText) || "falsetrue".contains(testText)) {
        return t ;
    }
    // otherwise veto:
    return null ;
};