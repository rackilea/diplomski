import javax.script.*;

public class Test {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Bindings obj = (Bindings)engine.eval("var obj = { value: 1 };  obj; ");
        Integer value = (Integer)obj.get("value");
        System.out.println(value); // prints: 1
    }
}