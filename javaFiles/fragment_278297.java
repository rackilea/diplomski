public class TryScripting {
    public static void main(String[] args) throws ScriptException {
    ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
    String makeFun = "function  hello() {\n" +
            "return \"hello world\";\n" +
            "}\n" +
            "{\n" +
            "}";
    engine.eval(makeFun);

    engine.eval("myVar = hello()");
    ret = engine.get("myVar");
    System.out.println(ret);
    }
}