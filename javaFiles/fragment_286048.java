private static class User {
  String handle;
  String name;
  long stackId;

  public String getHandle() { return handle; }
  public String getName() { return name; }
  public long getStackId() { return stackId; }

  @Override
  public String toString() { return "User{handle='"+handle+“', name='"+name+"', stackId="+stackId+"\’}”; }
}