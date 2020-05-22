public class StackOverflow {
    private Object toSave;

    @Test
    public void test() throws ScriptException {
        Consumer<String> saveValue = obj -> toSave = obj;
        ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("nashorn");
        ScriptContext context = jsEngine.getContext();
        context.setAttribute("saveValue", saveValue, ScriptContext.ENGINE_SCOPE);
        jsEngine.eval("saveValue('one')");
        Assert.assertEquals("one", toSave);
    }
}