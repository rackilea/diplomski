class GenericRequest {}

class SpecificRequest1 extends GenericRequest {
    void method1() {
        System.out.println("specific1");
    }
}

class SpecificRequest2 extends GenericRequest {
    void method2() {
        System.out.println("specific2");
    }
}

interface ReqInterface {
    void method();
}

class Specific1 implements ReqInterface {
    private final SpecificRequest1 req =new SpecificRequest1();

    @Override
    public void method() {
        req.method1();
    }
}

class Specific2 implements ReqInterface {
    private final SpecificRequest2 req =new SpecificRequest2();

    @Override
    public void method() {
        req.method2();
    }
}

public class Production {
    void method(ReqInterface req) {
        req.method();
    }

    public static void main(String[] args) {
        Production l3 = new Production();
        l3.method(new Specific1());
        l3.method(new Specific2());
    }
}