package goog;
import junit.framework.TestCase;
import watij.runtime.ie.IE;
import static watij.finders.SymbolFactory.*;
public class GTestCases extends TestCase {

 private static watij.runtime.ie.IE activeIE_m;
 public static IE attachToIE(String url) throws Exception {   
  if (activeIE_m==null)
     {
       activeIE_m = new IE();
    activeIE_m.start(url);
     } else {
       activeIE_m.goTo(url);
     }
  activeIE_m.bringToFront();
     return (activeIE_m);    
 }

 public static String getActiveUrl () throws Exception {  
  String currUrl = activeIE_m.url().toString();  
  return currUrl;
 }

 public void testGoogleLogin() throws Exception {
  IE ie = attachToIE("http://google.com");
     if ( ie.containsText("/Sign in/") ) {
      ie.div(id,"guser").link(0).click();
      if ( ie.containsText("Sign in with your") ||
        ie.containsText("Sign in to iGoogle with your")) {
       ie.textField(name,"Email").set("test@gmail.com");
       ie.textField(name,"Passwd").set("test");
       if ( ie.checkbox(name,"PersistentCookie").checked() ){
        ie.checkbox(name,"PersistentCookie").click();
       }
       ie.button(name,"signIn").click();       
      }
     }
     System.out.println("Login finished.");
    }

 public void testGoogleSearch() throws Exception {
  //IE ie = attachToIE( getActiveUrl() );
  IE ie = attachToIE( "http://www.google.com/advanced_search?hl=en" );
     ie.div(id,"opt-handle").click();
     ie.textField(name,"as_q").set("Watij");
     ie.selectList(name,"lr").select("English");
     ie.button(value,"Advanced Search").click();
     System.out.println("Search finished.");
 }

 public void testGoogleResult() throws Exception {
  IE ie = attachToIE( getActiveUrl() );
  ie.link(href,"http://groups.google.com/group/watij").click();
  System.out.println("Followed link.");
 }

}