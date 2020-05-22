ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");     
ScriptObjectMirror jsArray = (ScriptObjectMirror) engine.eval("var arr = []; arr");

@SuppressWarnings("unchecked")
List<Object> ls = jsArray.to(List.class);
ls.add(1);
ls.add(2);
ls.add(3);

System.out.println(ls); // [1, 2, 3]
engine.eval("print(arr)"); // 1,2,3
engine.eval("print(Array.isArray(arr))"); // true