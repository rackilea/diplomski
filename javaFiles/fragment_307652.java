// Create a script engine manager
    ScriptEngineManager factory = new ScriptEngineManager();

    // Create a JavaScript engine
    ScriptEngine engine = factory.getEngineByName("JavaScript");

    // Evaluate JavaScript code from String
    engine.eval("print('Hello, World')");