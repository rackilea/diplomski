public class MyException extends Exception{
   String errorMessage; 

   public MyException(String message, Exception cause){
     super();

     if(cause instanceof MyException){
         // already wrapped
         errorMessage= cause.getErrorMessage();          
         initCause(cause.getCause());
     }
     else{
         // not my Exception
         errorMessage=message;
         initCause(cause); 
     } 
 ´               

   }

}