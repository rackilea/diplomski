public class SessionClient {
     public void performOperation() {
         try {
            MySessionInterface session = ServiceLocator.getLocalSession(MySessionInterface.class);
            // TODO :: perform business logic here
        } catch (NamingException e) {
             // TODO :: handle exception
        }
    }
}