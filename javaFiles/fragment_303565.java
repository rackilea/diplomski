public static void main(String[] args) throws Exception {
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine jsEngine = sem.getEngineByName("JavaScript");
    printResult(jsEngine, "Hello World", "'Hello World'");
    printResult(jsEngine, "Simple Math", "123 + 456");
}