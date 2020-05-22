ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
String userVar[] = {"a = 1", "b = 1", "c = 0"};

for (String s : userVar) {
    engine.eval(s);
}

String expr = "a & b & c";
System.out.println(engine.eval(expr));