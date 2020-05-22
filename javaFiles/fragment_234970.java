public class MyEnvironment extends StandardEnvironment {
   @Override
   public String resolvePlaceholders(String location) {
      if (location.equals("myConfiguration")) {
         //Whatever you can do, SpEL, method call...
         //Return database.properties path at runtime in this case
         return getRootFolder() + "datasource.properties"; 
      } else {
         return super.resolvePlaceholders(text);
      }
   }
}