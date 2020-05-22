ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("JavaScript");
String foo = "( (21 + 3) / 4 ) ";
try {
    System.out.println(engine.eval(foo));
} catch (ScriptException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}