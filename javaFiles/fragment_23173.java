private int square(int x) {
    return x * x;
}

@Test
public void example() throws ScriptException {
    TypedScriptEngine engine = JScriptBox.create()
        .set("square").toFunc1(this::square)
        .set("x").toValue(9)
        .buildTyped(Nashorn.language());
    int squareOfX = engine.eval("square(x)", Integer.class);
    Assert.assertEquals(81, squareOfX);
}