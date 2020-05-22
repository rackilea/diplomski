@JsonDeserialize(using = CustomDeserializer.class)
public class Storage {

   private Map<Integer, Item> items;

   public Storage(Map<Integer, Item> map) {
    this.items = map;
   }

   ...

}