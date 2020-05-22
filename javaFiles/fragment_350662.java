import javax.script.*;

public class CallBack {
  public void invoke(Runnable runnable) {
    runnable.run();
  }

  public static void main(String[] args) throws ScriptException {
    ScriptEngine js = new ScriptEngineManager().getEngineByExtension("js");
    js.getContext().setAttribute("callBack", new CallBack(),
        ScriptContext.ENGINE_SCOPE);
    js.eval("var impl = { run: function () { print('Hello, World!'); } };\n"
        + "var runnable = new java.lang.Runnable(impl);\n"
        + "callBack.invoke(runnable);\n");
  }
}