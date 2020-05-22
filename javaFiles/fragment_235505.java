//with the following imports:
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public static void main (String[ ] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object result = engine.eval("var a = 4, b = 5; a * b");
            System.out.println(result);
        }catch (ScriptException e){
            e.printStackTrace();
        }
    }