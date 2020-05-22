interface DatabaseColumn {
  String columnName();
}


enum UserColumns implements DatabaseColumn {
  ID("id"),
  USERNAME("username"),
  PASSWORD("password");

  private final String name;

  UserColumns(String name) {
    this.name = name;
  }

  @Override public String columnName() {
    return name;
  }
}