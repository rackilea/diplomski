public class SecondTestClass {
    @Test
    @Parameters({"age"})
    public void testMethod(int age) {
        System.out.println("Age = " + age );
    }
}