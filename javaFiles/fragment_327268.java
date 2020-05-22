import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
  public static void main(String[] args) throws ScriptException {
    ScriptEngine pyEngine = new ScriptEngineManager().getEngineByName("python");
    Object Pyoutput = pyEngine.eval("2*3");
    System.out.println(Pyoutput.toString());
  }
}