ScriptEngineManager factory = new ScriptEngineManager();
ScriptEngine engine = factory.getEngineByName("JavaScript");
Invocable inv = (Invocable) engine;
FileReader jsonata = new FileReader("jsonata.js");

// load the JSONata processor
engine.eval(jsonata);

// read and JSON.parse the input data
byte[] sample = Files.readAllBytes(Paths.get("sample.json"));
engine.put("input", new String(sample));
Object inputjson = engine.eval("JSON.parse(input);");

// query the data
String expression = "$sum(Account.Order.Product.(Price * Quantity))";  // JSONata expression
Object expr = inv.invokeFunction("jsonata", expression);
Object resultjson = inv.invokeMethod(expr, "evaluate", inputjson);

// JSON.stringify the result
engine.put("resultjson", resultjson);
Object result = engine.eval("JSON.stringify(resultjson);");
System.out.println(result);