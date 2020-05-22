import netscape.javascript.*;
import java.applet.*;
import java.awt.*;
class MyApplet extends Applet {
     public void init() {

         // requesting the JSObject
         JSObject win = JSObject.getWindow(this);

         // here you call a javascript function
         win.call("myJavscriptFunction", null);

         // if you wish to pass an argument to the javascript function,
         // do the following
         String myString = "World!";
         final Object[] args = { myString };  
         win.call("myJavascriptFunction2()", args);
     }
}