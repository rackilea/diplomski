import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Main {
  public static void main(String[] args) throws ScriptException {
    String str = "2+2";
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    System.out.println(engine.eval(str));
    } 
}