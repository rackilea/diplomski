Globals globals = JmePlatform.standardGlobals();

public void compile(File file) {
    try {
        globals.load(new FileReader(file), "script").call();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

public Object invoke(String func, Object... parameters) {
    if (parameters != null && parameters.length > 0) {
        LuaValue[] values = new LuaValue[parameters.length];
        for (int i = 0; i < parameters.length; i++)
            values[i] = CoerceJavaToLua.coerce(parameters[i]);
        return globals.get(func).call(LuaValue.listOf(values));
    } else
        return globals.get(func).call();
}