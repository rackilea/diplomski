import org.graalvm.polyglot.*;

class Test {
    public static void main(String[] args) {
        Context context = Context.newBuilder().allowIO(true).build();
        Value v = context.getPolyglotBindings();
        v.putMember("arguments", 123);

        String script = "import polyglot\n" +
                        "polyglot.import_value('arguments')";
        Value array = context.eval("python", "[1,2,42,4]");
        Value result = context.eval("python", script);
        System.out.println(result);
    }
}