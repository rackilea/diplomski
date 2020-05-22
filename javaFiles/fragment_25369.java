public class VirtualServer {
   private String kind;
   private String selfLink;
   private List<VirtualServer.Item> items;
   ...

   public static class Item {
       private String kind;
       private String name;
       private String partition;
       private String fullPath;

       ...
   }
}