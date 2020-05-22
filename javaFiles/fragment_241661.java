@RunWith(Theories.class)
public class BaseTests {

    protected Setup o;

    @Before
    public void setUp();

    @Theory
    public void AddSevenTest(
         @TestedOn(ints = {0, 5, 10})int x){

         o.implementation.addSevenAnd(x);
         verify(o.storageMock).save(x + 7);
    }

    static class Setup {
         IStorage storageMock;
         ITesting implementation;
    }
}

public class Tests1 extends BaseTests {
    @Ovveride @Before
    public void setUp() {
         // ...
    }
}

public class Tests2 extends BaseTests {
    @Ovveride @Before
    public void setUp() {
         // ...
    }
}

@RunWith(Suite.class)
@Suite.SuiteClasses({
    Tests1.class,
    Tests2.class
})

public class Tests {   
}