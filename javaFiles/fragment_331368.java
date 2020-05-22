import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import org.apache.lucene.analysis.Analyzer;

public class RunMyAnalyzer {

    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        String filename = "my-analyzer.rb";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("jruby");
        Reader reader = new FileReader(filename);
        engine.eval(reader);

        // Instantiate the JRuby class, and cast the result of eval.
        Analyzer analyzer = (Analyzer) engine.eval("MyAnalyzer.new");

        // You can then use this analyzer like a Lucene Analyzer
    }
}