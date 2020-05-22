public class MyTest {
    private static Records testRec;
    @Test
    public void testAbc() {
        Assert.assertTrue(
            "There should be some thing.",
            MyTest.testRec.getEmployee() > 0);
    }
}