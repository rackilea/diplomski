int eval(String code) {
    code = "function f () {" + code + "} f()"; // Or otherwise
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("JavaScript");
    engine.put("score", 1.4);
    Number num = (Number) engine.eval(code);
    return num.intValue();
}