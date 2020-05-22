package nashor;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.*;

public class NashorMain {

    public static void main (String[] args) throws ScriptException  {

        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");    
        Bindings b = nashorn.createBindings();
        b.put("global", "GLOBAL");
        nashorn.setBindings(b, ScriptContext.GLOBAL_SCOPE);

        b = nashorn.createBindings();
        b.put("info", new NashorInfo(nashorn));
        b.put("engineVar", "engine");
        nashorn.setBindings(b, ScriptContext.ENGINE_SCOPE);

        nashorn.eval("newEngineVar = 'engine'");
        nashorn.eval("print('Engine vars:'); for each (var key in info.getEngineScopeKeys()) print (key)");
        nashorn.eval("print();print('Global vars:'); for each (var key in info.getGlobalScopeKeys()) print (key)");
    }

    public static class NashorInfo {

        private ScriptEngine scriptEngine;

        public NashorInfo (ScriptEngine scriptEngine) {
            this.scriptEngine = scriptEngine;
        }

        public String[] getEngineScopeKeys() {
            return scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE).keySet().toArray(new String[]{});
        }

        public String[] getGlobalScopeKeys() {
            return scriptEngine.getBindings(ScriptContext.GLOBAL_SCOPE).keySet().toArray(new String[]{});
        }
    }


}