public class MapAccessor{

private Map<String, Object> mappings;

   public MapAccessor(Map<String, Object> mappings) {
      this.mappings = mappings;
   }

   public Object getAddress(){
       return this.mappings.get("address");
   }

   public boolean hasAddress(){
       return this.mappings.containsKey("address");
   }
   ... 
}