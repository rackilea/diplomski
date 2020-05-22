import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Test {
  public static void main(String[] args) throws Exception{
    ScriptEngineManager manager= new ScriptEngineManager();
    ScriptEngine seng= manager.getEngineByName("JavaScript");
    String bar = "3+3+3";
    System.out.println(seng.eval(bar));
    } 
}