import javax.script.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import scala.tools.nsc.interpreter.IMain;
import scala.tools.nsc.settings.MutableSettings.BooleanSetting;


public class TestScript {

    public static void main(String... args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("scala");

        ((BooleanSetting)(((IMain)engine)
               .settings().usejavacp()))
                    .value_$eq(true);

        String testScript = "var a:Int =  10";
        engine.eval(testScript);

        String testScript2 = "println(a)";
        engine.eval(testScript2);

        String testScript3 = "println(a+5)";
        engine.eval(testScript3);
    }
}