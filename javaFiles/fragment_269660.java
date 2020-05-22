public class Eval {

    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

        engine.put("a", 45);
        Number val = (Number) engine.eval("a*3");
        System.out.println(val.doubleValue());
    }
}