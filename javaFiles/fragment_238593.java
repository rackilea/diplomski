public class MySingletonClass{

   private MySingletonClass(){

   }
   public static MySingletonClass getInstance(){
         return IntiailizationOnDemandClassholder.instance;
   }

   private static class IntiailizationOnDemandClassHolder{
         private static final MySingletonClass instance = new MySingletonClass();

   }

}