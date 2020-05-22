import javax.script.*;

public class EvalJRubyScript {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();

        int playerHealth = 0;

        ScriptEngine engine = factory.getEngineByName("jruby");
        ScriptContext context = engine.getContext();
        context.setAttribute("playerHealth", playerHealth, ScriptContext.ENGINE_SCOPE);

        try {
            engine.eval("$playerHealth = 42");
            playerHealth = (Integer)context.getAttribute("playerHealth",  ScriptContext.ENGINE_SCOPE);

            System.out.println(playerHealth);
        } catch (ScriptException exception) {
            exception.printStackTrace();
        }
    }
}