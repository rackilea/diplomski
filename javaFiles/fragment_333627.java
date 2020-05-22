public class AddPropertyToObject {
    public static void main(String[] args) {
        new ContextFactory().call(new ContextAction(){

            @Override
            public Object run(Context ctx) {
                Scriptable scope = ctx.initStandardObjects();
                try {
                    Scriptable entity = ctx.newObject(scope);

                    NativeObject result = (NativeObject) ctx.evaluateString(
                        scope,
                        "({age:3, name:'bob'})",
                        "<inline>", 1, null);

                    result.put("surname", result, "Smith");

                    for (Entry<Object, Object> p : result.entrySet()) {
                        System.out.println(p.getKey() + ": " + p.getValue());
                    }

                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
                return null;
            }
        });   
    }
}