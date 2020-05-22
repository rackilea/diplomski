private static class User {
  String handle;
  String name;

  public String getHandle() { return handle; }
  public String getName() { return name; }

  @Override
  public String toString() { 
    return "User{handle='" + handle + “\', name='" + name + "\’}”; 
  }
}