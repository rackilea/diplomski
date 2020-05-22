public class Controller { 
   public void someControllerMethod(){
      MDC.put("user", SecurityContext.getCurrentUser().getName());
      try{
        //do your work here
      }finally{
         MDC.clear();
      }
   }
}