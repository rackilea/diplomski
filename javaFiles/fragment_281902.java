engine.eval("function isArray(obj) {" +
                "  return obj.constructor == Array;" +
                "}");
Object obj = engine.eval("[1,2,3,4]");
Invocable invocableEngine = (Invocable) engine;
System.out.println(invocableEngine.invokeFunction("isArray", obj)); //true