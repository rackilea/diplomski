package com.xxx.jython;
import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;

public class PythonScriptTest {

    public static void main(String[] args) {
        PythonScriptTest f = new PythonScriptTest();
        f.executePythonScript();
    }

    public PythonScriptTest(){
    }

    public void executePythonScript() {
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile("/home/XXX/XXX/util.py");
            PyFunction pyFuntion = (PyFunction) interpreter.get("InGameCommand", PyFunction.class);

            pyFuntion.__call__();
    }

    public void SpawnPlayer() {
            System.out.println("Run SpawnPlayer method ##################");
    }
}