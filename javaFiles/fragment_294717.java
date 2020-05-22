public final class Modules {

  public static List<Object> getModules(App application) {
    ArrayList<Object> modules = new ArrayList<Object>();
    modules.add(new MainModule(application));
    return modules;
  }
}