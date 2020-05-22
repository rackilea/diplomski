import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main
{
    public static void main(final String[] args) throws ScriptException
    {
        final ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        final ScriptEngine engine = scriptEngineManager.getEngineByName("javascript");
        final String foo = "4 * 24 + Math.sqrt(36) - 5";
        System.out.println(engine.eval(foo));
    }
}