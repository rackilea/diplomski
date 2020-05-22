public static void main(String[] args) throws Exception {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");

    FileReader f = new FileReader("Multiplier.py");
    engine.eval(f);
    Object x = engine.get("x");
    System.out.println("x: " + x);
}