// .. other imports
import javax.script.ScriptException;

// your method signature
public void actionPerformed (ActionEvent e) throws ScriptException {

// ...

ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine se = manager.getEngineByName("JavaScript");        
Object result = se.eval(createEquasion);
finalAnswer = result.toString();
answer.setText(finalAnswer);

// ...