class Broker1 extends BrokerAbstract<Object> {
   private OriginalBroker1 original;       

   public boolean login(String user, String pass, Map<String,Object> options) {
      return original.doLogin(user, pass);  // ignore options
   }
   public boolean login(String user, String pass) {
      return login(user, pass, null);  // third parameters will be ignored
   }
   public int getStatus(Map<String,Object> options) { /*...*/ return 0; }
   public boolean sendRequest(Map<String,Object> options) { /*...*/ return false; }
   public Object getData(Map<String,Object> options) { 
      return original.getData();  // OriginalBroker1.getData():Object
   }
   public boolean logOff(Map<String,Object> options) {
      return original.doLogout((boolean) options.get("clearSession"));
   }
   public boolean logoff() {
      HashMap<String,Object> options = new HashMap<String,Object>();
      options.put("clearSession", true);
      return logoff(options);   // proxy to original method
   }
}