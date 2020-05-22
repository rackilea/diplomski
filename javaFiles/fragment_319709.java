public void setValuesProvider(ValuesProvider valuesProvider) {
    if (this.valuesProvider != null) {
        throw new IllegalStateException("Dependency already set");
    }
    this.valuesProvider = valuesProvider;
}