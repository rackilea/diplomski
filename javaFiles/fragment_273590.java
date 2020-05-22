public class DBObjectMapper{
   private Map<String, Object> map = new HashMap<String, Object>();
   private String tableName;

   private DBObjectMapper(String tableName){
       this.tableName=tableName;
   }

   public add(String key, Object value){
     map.put(key,value);
   }

   public <T extends Object> T get(String key) {
      return (T) map.get(key);
   }

   public String getTableName(){
      return tableName;
   }
}