public static void main(String[] ar) {
    String script = "function random(min, max) { "
            + "return Math.floor(Math.random() * (max - min + 1)) + min; }";
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    Invocable invocable = (Invocable)engine;
    try {
        engine.eval(script);
        for (int i = 0; i < 100; i++) {
            Double result = (Double)invocable.invokeFunction("random", 1, 50);
            System.out.println(result.intValue());
        }
    } catch (ScriptException | NoSuchMethodException e) {
        e.printStackTrace();
    }
}