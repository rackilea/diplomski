class Entity {

    private String id;
    private String version;
    private JsonNode license;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public JsonNode getLicense() {
        return license;
    }

    public void setLicense(JsonNode license) {
        this.license = license;
    }

    public void setLicenses(JsonNode license) {
        this.license = license;
    }

    public String retrieveLicense() {
        if (license.isArray()) {
            return license.elements().next().path("type").asText();
        } else if (license.isObject()) {
            return license.path("type").asText();
        } else {
            return license.asText();
        }
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", version=" + version + ", license=" + license + "]";
    }
}