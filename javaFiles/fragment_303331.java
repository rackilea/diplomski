class ClassWithInternalList {
    private List<String> reallyImportantData;

    public List<String> getImmutableViewOfData() {
        // Take advantage of the java.util.Collections tool for making a List immutable.
        return Collections.unmodifiableList(reallyImportantData);
    }

    public List<String> getSafeCopyOfData() {
        // Return a copy that the caller can modify without changing reallyImportantData.
        return new ArrayList<String>(reallyImportantData);
    }

    public List<String> justGetTheData() {
        // Return a reference to reallyImportantData that the caller can modify at will.
        return reallyImportantData;
    }
}