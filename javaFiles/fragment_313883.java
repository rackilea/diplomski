public class Test {

public void setParam(N... n) {
    System.out.println("Calling set param...");
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args) throws Exception {
    Test t=new Test();
    Class<?> c = Class.forName("test.Test");
    Method  method = c.getMethod ("setParam", N[].class);
    method.invoke(t, (Object) new N[]{});
}
}