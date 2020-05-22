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

        final String script1 = "import groovy.json.JsonOutput\n" +
                "\n" +
                "def json(Map map) {\n" +
                "    return new JsonOutput().toJson(map)\n" +
                "}\n" +
                "\n" +
                "println json([test: 1])";

        final CompiledScript compiledScript1 = ((Compilable) engine).compile(script1);

        //Execute some instruction to generate 'script2'
        final String script2 = "println 'Running second script...'; println json([test: 2]);";
        final CompiledScript compiledScript2 = ((Compilable) engine).compile(script2);

        compiledScript1.eval(bindings);
        compiledScript2.eval(bindings);
    }
}