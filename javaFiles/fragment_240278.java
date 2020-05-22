public enum AuthorizationRoleEnum {
  USER("user"),
  ADMIN("admin");

  private final String value;

  AuthorizationRoleEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

}