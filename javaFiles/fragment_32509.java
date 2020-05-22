import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SimpleTests {

    public static void main(String[] args) {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            String exp = "some double value"+ senti_op +senti_score;
            try {
                System.out.println(engine.eval(exp));
            } catch (ScriptException e) {

                e.printStackTrace();
            }


    }
}