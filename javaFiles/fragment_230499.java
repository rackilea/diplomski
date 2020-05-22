public class SquareTest {
    @Test
    public void testSquare {
        double[] expectedResults = { 0, 1, 4, 9 };
        double[] results = Square.square(new double[] { 0, 1, 2, 3 });
        Assert.assertArrayEquals("Not the desired results.", expectedResults, results, 0.00001);
    }
}