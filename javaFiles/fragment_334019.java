if (resourceObject==null) {
throw new CustomException("Null pointer for resource object detected");
}

public class CustomException extends Exception {
   public CustomException (String errorMsg) {
   super(errorMsg);
  }
}