ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("JavaScript");
// read script file
engine.eval(Files.newBufferedReader(Paths.get("C:/Scripts/Jsfunctions.js"), StandardCharsets.UTF_8));

Invocable inv = (Invocable) engine;
// call function from script file
inv.invokeFunction("yourFunction", "param");