String script = "function abc(x,y) {return x+y;}";
Context context = Context.enter();
try {
    ScriptableObject scope = context.initStandardObjects();
    Scriptable that = context.newObject(scope);
    Function fct = context.compileFunction(scope, script, "script", 1, null);
    Object result = fct.call(
            context, scope, that, new Object[] {2, 3});
    System.out.println(Context.jsToJava(result, int.class));
} finally {
    Context.exit();
}