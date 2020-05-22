public double calc(String input) {
    int result;
    ScriptEngineManager sem= new ScriptEngineManager();    
    ScriptEngine engine = sem.getEngineByName("JavaScript");     
    result = (Double)engine.eval(input)
    return result;
}