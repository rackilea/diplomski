package so;
import java.io.InputStreamReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Nashorn {
    public static void main(String[] args) {
        try (InputStreamReader in = resource()) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval(in);
            Invocable invocable = (Invocable) engine;
            Database database = new DatabaseImpl();
            Object x = invocable.invokeFunction("run", database);
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStreamReader resource() throws Exception {
        return new InputStreamReader(Nashorn.class.getResourceAsStream("db.js"), "utf-8");
    }

}