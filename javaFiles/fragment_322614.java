public class A {
    public void theMethod(ArrayList<Object> args) { // do stuff 
    }
}

public class B {
    public void reflectingMethod(ArrayList<Object> args) {
        Method method;
        try {
            method = A.class.getMethod("theMethod", args.getClass());
            method.invoke(new A(), args);
        } catch (Exception e) {}
    }
}