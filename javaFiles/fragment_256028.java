import java.util.ArrayList;

class Group {

   public String key;
   public String value;

   public String getKey() {
      return key;
   }

   public String getValue() {
      return value;
   }

   Group(String v, String k) {
      this.key = k;
      this.value = v;
   }

   @Override
   public String toString() {
      return this.key + " " + this.value;
   }
}

public class Datastructure {

   public static void main(String[] args) {
      ArrayList<Group> list = new ArrayList<>();
      list.add(new Group("0, 0, 0, 0, 1, 0, 2", "A"));
      list.add(new Group("0, 0, 3, 0, 1, 0, 2", "A"));
      list.add(new Group("0, 2, 0, 0, 1, 0, 2", "B"));
      list.add(new Group("0, 0, 0, 0, 1, 0, 2", "A"));

      findKeyList(list, "A");
   }

   public static void findKeyList(ArrayList<Group> list, String search) {
      if (!list.isEmpty()) {
         for (Group element : list) {
            if (element.getKey().equals(search)) {
               System.out.println(element.toString());
            }
         }
      }
   }

}