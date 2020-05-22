class BaseTest {
    private final int i = 1;

    void test(Object o) {
        if (getClass().isInstance(o)) {                
            TestAccess to = TestAccess.class.cast(o);
            //System.out.println(to.i);  // ERROR: i has private access in BaseTest
        }
    }
}

class TestAccess extends BaseTest{}