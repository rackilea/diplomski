private ResourceConfig createResourceConfig(WebConfig webConfig)
        throws ServletException {
    final Map<String, Object> props = getInitParams(webConfig);
    final ResourceConfig rc = createResourceConfig(webConfig, props);
    rc.setPropertiesAndFeatures(props);
    return rc;
}