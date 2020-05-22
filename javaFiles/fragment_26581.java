import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;

CompiledScript compiledScript = ((Compilable)engine)
    .compile("function func(x) { return " + function + "}");
compiledScript.eval(compiledScript.getEngine()
    .getBindings(ScriptContext.ENGINE_SCOPE));

Invocable funcEngine = (Invocable) compiledScript.getEngine();

// . . .

total += 0.001 * ((Number)funcEngine.invokeFunction("func", i)).doubleValue();