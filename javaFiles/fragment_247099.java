public class TestScriptEngine {

    private static final String script = "var customFunction = function(parameter) {\n" +
            "\treturn parameter*parameter;\n" +
            "};\n" +
            "\n" +
            "println(customFunction(10));\n";

    public static void main(String[] args) {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code User's input
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace(); 
        }
    }

}