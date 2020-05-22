import javax.script.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestScript {

    public static void main(String... args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("scala");

...