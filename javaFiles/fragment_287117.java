import org.python.core.PyException;
import org.python.core.PyCode;
import org.python.util.PythonInterpreter;

public class Main {
  public static void main(String[] args) throws PyException {

    PythonInterpreter interp = new PythonInterpreter();
    System.out.println("ā".codePointAt(0));    // outputs 257
    interp.exec("print ord('ā')");             // outputs 63

    String s = "print ord(u'ā')";
    PyCode code = interp.compile(s);
    interp.exec(code);                         // outputs 257
  }
}