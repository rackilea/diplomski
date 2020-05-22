private static class User {
  String handle;
  String name;

  public String getHandle() { return handle; }
  public String getName() { return name; }

  @JsonIgnore
  public String getDisplayName() {
    return getName() + “ (" + getHandle() + ")";
  }

  @Override
  public String toString() { 
    return "User{handle='" + handle + "\', name='" + name + "\', displayName='" + getDisplayName() + "'}"; 
  }
}