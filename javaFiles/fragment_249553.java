import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Test {
  public static void main(String[] args) throws Exception{
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String expression= "10+(8*9)";
    System.out.println(engine.eval(expression));
    } 
}