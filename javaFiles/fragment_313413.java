public interface User {
 public <T extends Module<T>> boolean hasPermission(Module<T> module, Permission<T> usage);
 }

public interface Permission<T extends Module<T>> {
  String describe();
}

enum Reports implements Module<Reports> {
  REPORTS
}

enum ReportsPermissions implements Permission<Reports> {
   ENABLE_COOL_REPORT("Enables the cools reports"),
   ALLOWS_EXPORTING_THE_REPORTS("Allow exports the cools reports");

   private final String description;

    ReportsPermissions(String description) {
      this.description = description;
    }

    @Override
    public String describe() {
      return description;
     } 
  }

  enum ImportPermissions implements Permission<Import> {
    ALLOWS_IMPORTING("Allows importing the data.");
    etc
  }