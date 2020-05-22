class Asset {

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "type")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = ImageAssetProperties.class, name = "image"),
        @JsonSubTypes.Type(value = DocumentAssetProperties.class, name = "document") })
    private AssetProperties properties;

    public AssetProperties getProperties() {
        return properties;
    }

    public void setProperties(AssetProperties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Asset [properties("+properties.getClass().getSimpleName()+")=" + properties + "]";
    }
}