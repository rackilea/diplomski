import bsh.EvalError;
import bsh.Interpreter;
public class X {

    public static void main(String[] args) throws EvalError {
        Interpreter bsh = new Interpreter();
        String expr = "20>10";
        bsh.eval("boolean b="+expr);
        Boolean b = (Boolean)bsh.eval("b");
        System.out.println(b);
    }

}