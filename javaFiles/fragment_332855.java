import javax.script.*;

public class Main {
  public static void main(String[] args) throws Exception {

    final ScriptEngineManager factory = new ScriptEngineManager();
    final ScriptEngine engine = factory.getEngineByName("nashorn");
    final String raw = "I am the raw value injected";
    final ScriptContext ctx = new SimpleScriptContext();

    // **This is the inserted line**
    ctx.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);

    ctx.setAttribute("raw", raw, ScriptContext.ENGINE_SCOPE);

    String script = "var result = 'I am a result';";
    script += "java.lang.System.out.println(raw);";
    script += "'I am a returned value';";

    final Object res = engine.eval(script, ctx);
    System.out.println(ctx.getAttribute("result"));
    System.out.println(res);
 }
}