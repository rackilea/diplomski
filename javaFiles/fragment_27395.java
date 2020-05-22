package ex.two

public class TestDerivateInOtherPackage extends TestDerivate {
    public void test(){
         // legal
         testPublic();
         //illegal since it is only package visible
         testPackage();
    }

    @Override
    public void testPublic() {
        // still legal
    }

    @Override
    void testPackage() {
        // still illegal
    }

}