@Override
public Map<String, Object> getProperties() {
    Map<String, Object> props = new HashMap<>();
    props.put("jersey.config.server.provider.classnames",
              "org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature");
    return props;
}