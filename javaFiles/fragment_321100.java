import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
   public static void main(String[] args) throws Exception {
       JSObject jsobj = new AbstractJSObject() {
           @Override
           public Object getMember(String name) {
               // return a Runnable for "func"
               if (name.equals("func")) {
                  return new Runnable() {
                      @Override
                      public void run() {
                         System.out.println("in run!");
                      }
                  };
               }
               return null;
           }
       };

       ScriptEngineManager m = new ScriptEngineManager();
       ScriptEngine e = m.getEngineByName("nashorn");
       e.put("obj", jsobj);
       e.eval("obj.func()");
   }
}