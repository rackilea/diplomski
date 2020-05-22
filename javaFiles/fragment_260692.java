abstract class BrokerAbstract<T> {
   private int errCode;
   private String errMessage;

   abstract public boolean login(String user, String pass, Map<String,Object> options);
   abstract public int getStatus(Map<String,Object> options);
   abstract public boolean sendRequest(Map<String,Object> options);
   abstract public T getData(Map<String,Object> options);
   abstract public boolean logOff(Map<String,Object> options);

   protected void setError(int code, String message) {
      this.errCode = code;
      this.errMessage = message;
   }

   public int getErrorCode() { return this.errCode; }
   public String getErrorMessage() { return this.errMessage; }
}