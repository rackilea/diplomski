public enum Config {
  DB_NAME("db_name"),
  DB_HOST("db_host_name_specified_in_file"),
  SOME_NUMBER("some_number"),
  ;

  private final String propertyName;

  private Config(String propertyName) {
    this.propertyName = propertyName;
  }

  public String getPropertyName() {
    return propertyName;
  }

  public InjectConfig annotation() {
    // Create an implementation of InjectConfig for ease of binding.
    return new InjectConfig() {
      @Override public Class<? extends Annotation> annotationType() {
        return InjectConfig.class;
      }

      @Override public Config value() {
        return Config.this;
      }

      @Override public boolean equals(Object obj) {
        if (obj == this) {
          return true;
        } else if (!(obj instanceof InjectConfig)) {
          return false;
        }
        return value() == ((InjectConfig) obj).value();
      }

      /** @see Annotation#hashCode */
      @Override public int hashCode() {
        return (127 * "value".hashCode()) ^ value().hashCode();
      }
    };
  }

  @Retention(RetentionPolicy.RUNTIME)
  @BindingAnnotation
  public static @interface InjectConfig {
    Config value();
  }
}