package beanshell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import bsh.EvalError;
import bsh.Interpreter;

public class Demo_Eval {
    public static Interpreter i = new Interpreter();

    public static void main(String[] args) throws FileNotFoundException, IOException, EvalError, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        String userInput = "printValue()";

        Object result = i.eval(""
                + "public class EvalUserInput extends beanshell.Demo_Eval{"
                + "public static void getUserInput(){"
                + userInput+";"
                + "}"
                + "}");

        Class<?> noparams[] = {};
        Class cls = (Class) result;
        Object obj = cls.newInstance();
        cls.getDeclaredMethod("getUserInput", noparams).invoke(obj, null);
    }

    public static void printValue(){
        System.out.println("Printed");
    }
}