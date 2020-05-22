public class MyClass {
    private HashMap<String, Object> vars=new HashMap();

    private var(String s, Object o) {
        vars.put(s, o);
    }

    private Object var(String s) {
        return vars.get(s);
    }
}