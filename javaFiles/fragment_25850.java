public class Contact {

   private final int id;
   private final String name;
   private final String parent;
   private final String level;

   public Contact(String id, String name, String parent, String level) {
     this.id = id;
     this.name = name;
     this.parent = parent;
     this.level = level;
   }

   public int getId() {
     return id;
   }

   //... put the rest of the getter methods
}