public class Main {

    static class Shell extends ScriptableObject {

        @Override
        public String getClassName() {
            return "global";
        }

        public static void print(Context cx, Scriptable thisObj, Object[] args, Function funObj) {
            for (int i = 0; i < args.length; i++) {
                String s = Context.toString(args[i]);
                System.out.print(s);
            }
        }
    }

    public static void useJava6ScriptingEngine() throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
        jsEngine.eval("print('Hello, world!')");
    }

    public static void useRhinoDirectly() throws Exception {
        Context context = Context.enter();
        try {
            Shell shell = new Shell();
            String[] names = {"print"};
            shell.defineFunctionProperties(names, Shell.class, ScriptableObject.DONTENUM);
            Scriptable scope = context.initStandardObjects(shell);
            context.evaluateString(scope, "print('Hello, world!')", null, 0, null);
        } finally {
            Context.exit();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        useJava6ScriptingEngine();
        useRhinoDirectly();
    }
}