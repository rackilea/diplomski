import javax.script.*;
public class EvalScript {
    public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        Number number = (Number)engine.eval("(5)*(2+2)/(2)");
        System.out.println("abc = " + number);
    }
}