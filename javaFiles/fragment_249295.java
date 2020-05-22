import java.lang.reflect.Array;

public class GD<Item extends Comparable<Item>> {
   private Item[] data;
   private final int MAX_SIZE = 200;
   public GD(Class<Item> clazz) {
      data = (Item[]) Array.newInstance(clazz, MAX_SIZE);
   }

   public static void main(String[] args) {
     GD<String> g = new GD<String>(String.class);
   }
}