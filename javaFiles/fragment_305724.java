// Note singular name for enum
public enum ErrorCode { 
   INVALID_LOGIN(100, "Your login is invalid"),
   INVALID_PASSWORD(101, "Your password is invalid"),
   SESSION_EXPIRED(102, "Your session has expired");

   private final int code;
   private final String 

   private ErrorCode(int code, String message){
          this.code = code;
          this.message = message;
   }

   public String getMessage() {
       return message;
   }
}