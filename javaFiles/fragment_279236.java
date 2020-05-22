public class InheritedClass extends ParentClass {
    @Override
    public String doStuff(final String parameters) {
        if (parameters.equals("do parent")) {
            return super.doStuff(parameters);
        }
        return "child";
    }
}