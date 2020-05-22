import javax.script.*;
import jdk.nashorn.api.scripting.*;

public class Main {
   public static void main(String[] args) throws Exception {
      ScriptEngineManager m = new ScriptEngineManager();
      ScriptEngine e = m.getEngineByName("nashorn");
      ScriptObjectMirror thiz = (ScriptObjectMirror)e.eval("this");
      // ScriptObjectMirror.getOwnKeys(boolean) returns all own property names. 
      // "true" to return all non-enumerable property names as well.
      // This is equivalent to JS call:
      //     Object.getOwnPropertyNames(this)
      for (String key : thiz.getOwnKeys(true)) {
          System.out.println(key);
      }
   }
}