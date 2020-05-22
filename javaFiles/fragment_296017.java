package de.scrum_master.app;

public class Application {
  private int id = 1;
  private String name = "default";

  @ReadOnly
  public int getId() {
    return id;
  }

  @ReadOnly
  public String getName() {
    name = "hello world";
    id = 7564;
    return name;
  }

  public String getNameWithoutReadOnly() {
    name = "hello world";
    id = 7564;
    return name;
  }

  @ReadOnly
  public String getNameIndirectly() {
    modifyMembers();
    return name;
  }

  private void modifyMembers() {
    name = "hello world";
    id = 7564;
  }

  public static void main(String[] args) {
    Application application = new Application();
    application.getId();
    try { application.getName(); }
    catch (Exception e) { e.printStackTrace(System.out); }
    application.getNameWithoutReadOnly();
    try { application.getNameIndirectly(); }
    catch (Exception e) { e.printStackTrace(System.out); }
  }
}