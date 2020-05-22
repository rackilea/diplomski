class A {
    private Map importantData;

    public Map getImportantData() {
        return Collections.unmodifiableMap(importantData);
    }
}