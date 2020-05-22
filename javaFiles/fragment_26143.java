public aspect JsonToStringAspect {
    private interface JsonToString {}
    declare parents: com.mycompany.dto.* implements JsonToString;

    public String JsonToString.toString() {
        return "Overridden String through JsonToStringAspect";
    }
}