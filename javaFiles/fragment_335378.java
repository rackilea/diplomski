import javax.script.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import scala.tools.nsc.interpreter.IMain;
import scala.tools.nsc.settings.MutableSettings.BooleanSetting;

public class TestScript {

    public static void main(String... args) throws Exception {
          ....
          ((BooleanSetting)(((IMain)engine).settings()
                               .usejavacp())).value_$eq(true);

....