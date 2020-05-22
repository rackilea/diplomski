import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.*;

public class JDenticonClient {
    public static void main(String args[]) throws FileNotFoundException, ScriptException {
        String svgText = new JDenticonClient().getSVGDocumentText("ff8adece0631821959f443c9d956fc39", 200);
        System.out.print(svgText);
    }
    public String getSVGDocumentText(String hash, int size) throws FileNotFoundException, ScriptException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine scriptEngine = factory.getEngineByName("JavaScript");
        scriptEngine.eval(new FileReader("jdenticon.min.js"));
        return scriptEngine.eval("jdenticon.toSvg(\"" + hash + "\", \"" + size + "\")").toString();
    }
}