@ManagedBean(name = "managedBean") 
public class Bean { 
   private String val1; // getter and setter 
   private String val2; // getter and setter 
   private String res; // getter and setter 
   ... 

   public void someThingToDoListener(AjaxBehaviorEvent event) { 
       //res = some processing
    }

}