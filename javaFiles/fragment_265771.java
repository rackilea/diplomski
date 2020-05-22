public class ComputeTest {

...
    /**
     * Test of solve method, of class Compute.
     */
    @Test
    public void testSolve() {
        double a = 1;
        double b = -3;
        double delta = 5;
        double[] expectedResult = {-1,4}; // x1 and x2
        double[] result = Compute.solve(a, b, delta);

        assertArrayEquals(expectedResult, result); // make the actual test

        fail("The test case is a prototype."); // fail otherwise
    }

}