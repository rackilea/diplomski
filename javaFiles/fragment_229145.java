import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RhinoEngine {
    public static void main(String[] args) {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        try {
            engine.put("name", args[0]);
            engine.eval("print('Hello ' + name + '!')");
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }    
    }
}