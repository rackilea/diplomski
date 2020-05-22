import groovy.lang.Script;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;

public class LoadGroovyScriptExample {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Set<Class<? extends Script>> scripts = new Reflections("somepackage", new SubTypesScanner(false))
                .getSubTypesOf(Script.class);

        for (Class<? extends Script> script : scripts) {
            script.newInstance().invokeMethod("run", new Object[] { "test", "123" });
        }
    }
}