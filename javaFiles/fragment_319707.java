public void setValuesProvider(ValuesProvider valuesProvider) {
    this.valuesProvider = valuesProvider;
}

public Result parse(String parameterName) {
    if (valuesProvider == null) {
        valuesProvider = new DefaultValuesProvider();
    }

    List<Values> values = valuesProvider.getValues(parameterName);
    // do other stuff on values
    // ...
    return valuesMapper.transformValues(values, configuration);
}