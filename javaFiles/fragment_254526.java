public class SingletonFoo {
    private static Object _tn;

    public static <T> T instance(Class<T> t) {
        if (_tn != null) {
            return (T) _tn;
        }
        try {
            _tn = t.newInstance();
            ;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) _tn;
    }

    public static void main(String[] args) {
        System.out.println(SingletonFoo.instance(A.class));
    }

}

class A {
    public A() {
    }
}