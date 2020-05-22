public class Player {
   private Map<String,Object> attributes = new HashMap<>();

   public void setAttribute(String name, Object value) {
      attributes.put(name,value);
   }

   public Object getAttribute(String name) {
      return attributes.get(name);
   }
}