@Autowired
public void setDataProviders(Map<String,IDataProvider> dataProviders) {
    this.dataProviders = dataProviders;
}

@Autowired
@Value("${cms}")
public void setDataProviderName(String dataProviderName) {
    this.dataProviderName = dataProviderName;
}

public IDataProvider getDataProvider() {
    return dataProviders.get(dataProviderName);
}