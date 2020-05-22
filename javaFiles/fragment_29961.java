public class TestClass {

    @Test(groups = {"firstGroup"})
    public void firstMethod(Method method) {
        assertEquals(1, 1);
        System.out.println(method.getName());
    }

    @Test(groups = {"secondGroup"})
    public void secondMethod(Method method) {
        assertEquals(1, 1);
        System.out.println(method.getName());
    }

    @Test(groups = {"secondGroup"})
    public void thirdMethod(Method method) {
        assertEquals(1, 1);
        System.out.println(method.getName());
    }

    @Test(groups = {"secondGroup"})
    public void fourthMethod(Method method) {
        assertEquals(1, 1);
        System.out.println(method.getName());
    }
}