ScriptableObject scope = context.initStandardObjects();
Scriptable that = context.newObject(scope);
scope.defineProperty("req", request, ScriptableObject.READONLY);
scope.defineProperty("res", response, ScriptableObject.READONLY);
Object result = context.evaluateString(that, "function abc(request,response) {return response.body;}\n abc(req, res)", "script", 1, null);
System.out.println(Context.jsToJava(result, String.class));