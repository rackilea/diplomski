public class Test {     
    private long prop1;
    private long prop2;

    /* getters, setters, ...*/
}

public class TestReduced {
    private long prop1;

    public TestReduced(Test test) {
        this.prop1 = test.getProp1();
    }

    /* getters, setters, ...*/
}