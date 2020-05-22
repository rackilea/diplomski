ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("JavaScript");
String formula="a+b";

Bindings bindings = engine.createBindings();
bindings.put("a", 3);
bindings.put("b", 4);

engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);

Object res = engine.eval(formula);
System.out.println(res.toString());