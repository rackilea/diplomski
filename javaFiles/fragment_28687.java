import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

public class ScratchSpace {

    public static void main(String[] args) throws ScriptException {
        System.out.println("creationDate = " + getFileCreationDate(new File(".")));
    }

    private static Date getFileCreationDate(File file) throws ScriptException {
        final String script = "set myfile to \"" + file.getAbsolutePath() + "\"\n" +
                "set myinfo to info for myfile\n" +
                "creation date of myinfo";
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("AppleScript");
        final GregorianCalendar result = (GregorianCalendar) scriptEngine.eval(script);
        return result.getTime();
    }

}