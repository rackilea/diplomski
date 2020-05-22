class ReplaceNamingStrategy extends PropertyNamingStrategy {

    private static final long serialVersionUID = 1L;

    private Map<String, String> replaceMap;

    public ReplaceNamingStrategy(Map<String, String> replaceMap) {
        this.replaceMap = replaceMap;
    }

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        if (replaceMap.containsKey(defaultName)) {
            return replaceMap.get(defaultName);
        }

        return super.nameForGetterMethod(config, method, defaultName);
    }
}