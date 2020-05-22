ScriptEngineManager engineManager = new ScriptEngineManager();
    ScriptEngine engine = engineManager.getEngineByName("js");

    engine.eval("f = function() { return 1; }");

    Invocable invocable = (Invocable) engine;
    System.out.println(invocable.invokeFunction("f"));