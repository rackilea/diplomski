import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
   public static void main(String[] args) throws Exception {
      ScriptEngineManager m = new ScriptEngineManager();
      ScriptEngine e = m.getEngineByName("nashorn");

      // define an anoymous function
      JSObject multiply = (JSObject) e.eval("function(x, y) { return x*y; }");
      // call that anon function
      System.out.println(multiply.call(null, 34, 5));

      // define another anon function
      JSObject greet = (JSObject) e.eval("function(n) { print('Hello ' + n)}");
      greet.call(null, "nashorn");
   }
}