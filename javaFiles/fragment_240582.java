String script = "function abc(x,y) {return x+y;}"
        + "function def(u,v) {return u-v;}";
Context context = Context.enter();
try {
    ScriptableObject scope = context.initStandardObjects();
    context.evaluateString(scope, script, "script", 1, null);
    Function fct = (Function)scope.get("abc", scope);
    Object result = fct.call(
            context, scope, scope, new Object[] {2, 3});
    System.out.println(Context.jsToJava(result, int.class));
} finally {
    Context.exit();
}