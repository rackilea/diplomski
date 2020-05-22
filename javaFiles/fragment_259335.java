private static final Map<String, Class> TYPE_MAPPING = new ImmutableMap.Builder()
  .put("Bean01", Bean01.class)
  .put("Bean02", Bean02.class)
  .put("Bean03", Bean03.class)
  .build();

private Class getMapType(String header) {
  return TYPE_MAPPING.get(header);
}