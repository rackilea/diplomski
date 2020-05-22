public class AppConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty
  private ExtendedDatabaseConfiguration database = new ExtendedDatabaseConfiguration();

  public ExtendedDatabaseConfiguration getDatabaseConfiguration() {
    return database;
  }

  static class ExtendedDatabaseConfiguration extends DatabaseConfiguration {
    @Valid
    @NotNull
    @JsonProperty
    private String exampleProperty;
    public String getExampleProperty() { return exampleProperty; };
  }
}