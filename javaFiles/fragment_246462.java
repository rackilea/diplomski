public class MethodAndClassName {

    private String method;
    private String clazz;

    public MethodAndClassName(String method, String clazz) {
        this.method = method;
        this.clazz = clazz;
    }

    public String getMethodName() {
        return method;
    }

    public String getClassName() {
        return clazz;
    }
}