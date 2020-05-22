import java.io.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.util.Scanner;
import javax.script.ScriptException;

public class MathExpress {


    public static void main(String[] args) throws ScriptException {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter your arithematic oparation ");
        String Mathex= console.nextLine();

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        System.out.println(engine.eval(Mathex));




    }
}