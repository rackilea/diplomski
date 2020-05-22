import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecuteScript {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.eval(new InputStreamReader(ExecuteScript.class.getResourceAsStream("javascript.js")));
    printJSElement("root", engine.get("MoceanSettings"));
    }

    private static void printJSElement(String propName, Object element) {
        if (element instanceof List) {
            printJSList(propName, (List<Object>) element);
        } else if (element instanceof Map) {
            printJSMap(propName, (Map<Object, Object>) element);
        } else {
            printJSProperty(propName, element);
        }
    }

    private static void printJSMap(String propName, Map<Object,Object> objectMap) {
        for (Entry<Object,Object> entry : objectMap.entrySet()) {
            printJSElement(propName + "." + String.valueOf(entry.getKey()), entry.getValue());
        }
    }

    private static void printJSList(String propName, List<Object> objectList) {
        for (int i = 0; i < objectList.size(); i++) {
            printJSElement(propName + "[" + i + "]", objectList.get(i));
        }
    }

    private static void printJSProperty(String propName, Object value) {
        System.out.println(propName + " = " + value);
    }

}