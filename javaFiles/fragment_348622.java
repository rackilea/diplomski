import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class Test {
    public static void main(String[] args) throws Exception {
        String script = "var f = {\n" +
                        "  value: 0,\n" +
                        "  add: function(n) {\n" +
                        "    this.value += n;\n" +
                        "    return this.value;\n" +
                        "  }\n" +
                        "};\n" +
                        "f; // return object to Java\n";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        ScriptObjectMirror obj = (ScriptObjectMirror)engine.eval(script);
        System.out.println("obj.value = " + obj.getMember("value"));
        System.out.println("obj.add(5): " + obj.callMember("add", 5));
        System.out.println("obj.add(-3): " + obj.callMember("add", -3));
        System.out.println("obj.value = " + obj.getMember("value"));
    }
}