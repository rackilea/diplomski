public class Foo {
    // save ScriptEngine instance if you don't want to pass it as parameter
    public static void setMessage(ScriptEngine engine,String msg) {
        YourEngine myEngine = (YourEngine)engine.get("myEngine");
        // use myEngine...
        // or
        // ScriptContext sc = engine.getContext();
        // YourEngine myEngine = (YourEngine)sc.getAttribute("myEngine");

    }

}