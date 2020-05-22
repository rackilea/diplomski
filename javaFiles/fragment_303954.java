public void setSlingRequest(final SlingHttpServletRequest slingRequest) {
    this.slingRequest = slingRequest;
    // Use the one created by cq:defineObjects
    this.properties = (ValueMap)this.slingRequest.getAttribute("properties");
    // OR adapt the resource
    this.properties = this.slingRequest.getResource().adaptTo(ValueMap.class);
}

public void setResource(final Resource resource) {
    this.resource = resource;
    this.properties = this.resource.adaptTo(ValueMap.class);
}

public void setProperties(final ValueMap properties) {
    this.properties = properties;
}