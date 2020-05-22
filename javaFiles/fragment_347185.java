public class MyApp extends MyAppBase {
 public String[] getSpringConfigResource() {
  return new String[] { "someapp/appctx.xml", "util/appctx2.xml" }; 
 }

 protected void postApplicationLoad() {
  SomeServer server = springCtx.getBean("server");
  server.start();
 }

 public static void main(String args[]) {
  initLogging("com/me/myAppLog4j.xml", MyApp.class);    
  MyApp myApp = new MyApp ();
  myApp.loadConsoleApplication();
 }
}