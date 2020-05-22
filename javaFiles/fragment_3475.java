public static void main(String[] args) throws Exception {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("JavaScript");

    String s = "10 + 5";
    int  result = ((Double) engine.eval(s)).intValue();
    System.out.println(result); // 15
}