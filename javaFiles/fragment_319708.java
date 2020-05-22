public Parser(ValuesConfiguration configuration) {
    this(configuation, new DefaultValuesProvider());
}

public Parser(ValuesConfiguration configuration, ValuesProvider valuesProvider) {
    this.configuration = configuration;
    this.valuesProvider = valuesProvider;
}


public Result parse(String parameterName) {
    List<Values> values = valuesProvider.getValues(parameterName);
    // do other stuff on values
    // ...
    return valuesMapper.transformValues(values, configuration);
}