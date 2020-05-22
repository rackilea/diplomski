@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.PROPERTY, property = "attributes.objectType")
@JsonSubTypes({
  @JsonSubTypes.Type(value = ChildClass.class, name = "PartnerNetworkProfile")
})
class BaseClass {
    @JsonProperty("links")
    private Map<String, Link> links;
    @JsonProperty("attributes")
    private Attributes attributes;

    public Map<String, Link> getLinks() {
        return links;
    }

    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}

class ChildClass extends BaseClass {
    @JsonProperty("partnerName")
    private String partnerName;
    @JsonProperty("mpnId")
    private String mpnId;
    @JsonProperty("profileType")
    private String profileType;

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getMpnId() {
        return mpnId;
    }

    public void setMpnId(String mpnId) {
        this.mpnId = mpnId;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }
}

class Link {
    private String uri;
    private String method;
    private String[] headers;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
}
class Attributes {
    @JsonProperty("objectType")
    private String objectType;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}