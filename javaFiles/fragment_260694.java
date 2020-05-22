class Broker2 extends BrokerAbstract<Integer> {
   private OriginalBroker2 original;       

   public boolean login(String user, String pass, Map<String,Object> options) {
      int code = original.doLogin(user, pass, (String) options.get("sessionId"));
      if (0 != code) {
          setError(code, "Custom error message"); // could use enum here for messages...
          return false;
      } else {
          return true;
      }
   }
   public boolean login(String user, String pass, String sessionId) {
      HashMap<String,Object> options = new HashMap<String,Object>();
      options.put("sessionId", sessionId);
      return login(user, pass, options);
   }
   public int getStatus(Map<String,Object> options) { /*...*/ return 0; }
   public boolean sendRequest(Map<String,Object> options) { /*...*/ return true; }
   public Integer getData(Map<String,Object> options) { 
      return original.getData(options.get("key"));  // OriginalBroker2.getData(key:String):int
   }
   public boolean logOff(Map<String,Object> options) {
      return original.doLogout();
   }
   public boolean logoff() {
      return logoff(null);   // ignore third parameter
   }
}