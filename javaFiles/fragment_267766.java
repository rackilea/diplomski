public class CarNotFoundException extends Exception 
{        
     private static final long serialVersionUID = 1L;

     public String message;

     public CarNotFoundException(String msg) {
         this.message = msg;
     }

  // Overrides Exception's getMessage()
     @Override
     public String getMessage(){
         return message;
     }
 }