// .. other imports
import javax.script.ScriptException;

// .. the rest of your code
if(source==buteq){
  try{
     ScriptEngineManager manager = new ScriptEngineManager();
     ScriptEngine se = manager.getEngineByName("JavaScript");        
     Object result = se.eval(createEquasion);
     finalAnswer = result.toString();
     answer.setText(finalAnswer);
  catch(ScriptEngineManager e) {
     // handle exception
     System.err.println("Error evaluating the script: " + e.getMessage());
  }
}