import java.util.*;
import javax.script.*;

public class TestBindings {
    public static void main(String args[]) throws Exception {
        String script = "function doSomething() {var d = date}";
        ScriptEngine engine =  new ScriptEngineManager().getEngineByName("JavaScript");
        Compilable compilingEngine = (Compilable) engine;
        CompiledScript cscript = compilingEngine.compile(script);

        //Bindings bindings = cscript.getEngine().createBindings();
        Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
        for(Map.Entry me : bindings.entrySet()) {
            System.out.printf("%s: %s\n",me.getKey(),String.valueOf(me.getValue()));
        }
        bindings.put("date", new Date());
        //cscript.eval();
        cscript.eval(bindings);

        Invocable invocable = (Invocable) cscript.getEngine();
        invocable.invokeFunction("doSomething");
    }
}