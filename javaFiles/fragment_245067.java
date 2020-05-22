package demo;
import java.io.*; import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import javax.script.*;

public class StoreData {
  public static interface Stores {
    public String[] employees(String store);
  }

  public static Stores stores() throws IOException, ScriptException {
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine engine = sem.getEngineByName("JavaScript");
    AtomicReference<Stores> ref = new AtomicReference<>();
    engine.put("ref", ref);
    String adapt = "ref.set("
        + "new Packages.demo.StoreData.Stores({employees:employeesForStore})"
        + ");";
    try (Reader myFns = new FileReader("my_functions.js")) { // TODO encoding
      engine.eval(myFns);
      engine.eval(adapt);
      return ref.get();
    }
  }

  public static void main(String[] args) throws IOException, ScriptException {
    List<String> employees = Arrays.asList(stores().employees("uptown"));
    System.out.println(employees);
  }
}