class CorrelationMatrix {
    private AssetMatrix assetMatrix;
}

class AssetMatrix {
    @JacksonXmlProperty(isAttribute = true)
    private int numAssets;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Correlations> correlations;
}

class Correlations {
    @JacksonXmlProperty(isAttribute = true)
    private String asset;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Correlation> correlation;
}

class Correlation {
    @JacksonXmlProperty(isAttribute = true)
    private String asset;

    @JacksonXmlText
    private double correlation;
}