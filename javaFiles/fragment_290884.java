public static void main(String[] args) throws Throwable {
    ScriptEngine se = new ScriptEngineManager().getEngineByExtension("js");

    se.put("myObject", new MyClass());

    se.eval("myObject.someMethod('hello', function(e){ print(e); })");
}

public static class MyClass { // Class needs to be public
    public void someMethod(String s, Consumer<String> cons) {
        System.out.println(s);
        cons.accept("SomeString");
    }       
}