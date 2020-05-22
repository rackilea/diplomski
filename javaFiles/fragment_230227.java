import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class ScriptTest {

    public static void main(String[] args) throws ScriptException {
        final ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine engine = manager.getEngineByName("Groovy");

        final Bindings bindings = new SimpleBindings();
        bindings.put("a", 3);

        final String script1 = "println 'Running first script...'; def c = 2; def d = c + a; return d";
        final CompiledScript compiledScript1 = ((Compilable) engine).compile(script1);

        //Execute some instruction to generate 'script2'
        final String script2 = "println 'Running second script...';";
        final CompiledScript compiledScript2 = ((Compilable) engine).compile(script2);

        Integer returnedValue = (Integer) compiledScript1.eval(bindings);
        System.out.println("Returned value from the first script: " + returnedValue);

        if (returnedValue > 1) {
            compiledScript2.eval(bindings);
        }
    }
}