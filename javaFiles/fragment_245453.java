public class MainNoWaitAction {

   public static void main(String[] args) {
       List<String> links = new ArrayList<>();
       String title = "title";

       noWait(() -> links.addAll(rowFindElements(title)));
   }

   public static void noWait(NoWaitAction action) {
       turnOffWait();
       action.apply();
       turnOnWait();
   }

   public static void turnOnWait() { /* skipped */ }
   public static void turnOffWait() { /* skipped */ }

   public static List<String> rowFindElements(String title) {
       return new ArrayList<>(); // populate the list
   }
}