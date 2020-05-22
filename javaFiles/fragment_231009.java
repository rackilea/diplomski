class Test {
    public static void main(String[] args) {
        def engine = new ScriptEngineManager().getEngineByName("nashorn")
        engine.eval(new FileReader("E:/main.js"));
        def sys = engine.context.getAttribute("_sys")
        println sys
        def invocable = engine as Invocable

        def x = invocable.invokeMethod(sys, "hello")
        println x
    }
}