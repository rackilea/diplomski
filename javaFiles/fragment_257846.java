public class MainTestClass {
    @Test
    public void yourFirstTest() {
    ...
    }

    @Test
    public void yourSecondTest() {
    ...
    }

    @Test
    public void otherFirstTest() {
    ...
    }
}

public class WrapperTestClass {
    @Test
    public void yourFirstTest() {
       new MainTestClass().yourFirstTest();
    }

    @Test
    public void yourSecondTest() {
       new MainTestClass().yourSecondTest();
    }
}