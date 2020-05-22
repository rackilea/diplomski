public static void test() {
    for (int i = 0; i < 10000000; i++) {
        GroovyShell gs = new GroovyShell();
        Script script = gs.parse(" 'Hello, World';");
        Object result = script.run();
        assert result.equals("Hello, World");
        clearAllClassInfo(script.getClass());
    }                  
}

public static void clearAllClassInfo(Class<?> type) {
    try {
        Field globalClassValue = ClassInfo.class.getDeclaredField("globalClassValue");
        globalClassValue.setAccessible(true);
        GroovyClassValue classValueBean = (GroovyClassValue) globalClassValue.get(null);
        classValueBean.remove(type);
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }           
}