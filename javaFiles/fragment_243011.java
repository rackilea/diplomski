import javax.script.*;

public class ExecuteScript {

    public static void main(String[] args) throws Exception {
        // create a Java object
        ExecuteScript es = new ExecuteScript();

        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("println('Welcome to Java world')");

        // add the Java object into the engine.
        engine.put("es",es);

        ScriptEngineFactory sef = engine.getFactory();
        String s = sef.getMethodCallSyntax("es", "sayHi", new String[0]);
        // show the correct way to call the Java method
        System.out.println(s);
        engine.eval(s);
    }

    public static void sayHi(){
        System.out.println("hihi");
    }
}