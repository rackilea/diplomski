class Config {
  List<Class<?>> resourceClasses = new ArrayList<Class<?>>();

  @JsonProperty("resourceClasses")
  public void setResourceClasses(Collection<String> classNames) throws ClassNotFoundException {
    for (String className : classNames) {
      resourceClasses.add(Class.forName(className));
    }
  }     

}