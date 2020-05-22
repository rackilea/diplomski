@Test(dataProvider = "validReferenceNumbers", timeOut = 3000)
public final void testValidReferenceNumber(String referenceNumber) throws ScriptException {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("referenceNumber", referenceNumber);
    Bindings bindings = engine.createBindings();
    script.eval(bindings);
    ScriptObjectMirror scriptObjectMirror = (ScriptObjectMirror) bindings.get("validate");
    Object result = scriptObjectMirror.call(null, parameters);
    /* insert result assertions here */
}