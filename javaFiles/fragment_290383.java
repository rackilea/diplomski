public class SortTest extends TestCase {

    @Test
    public void testFindRanks() {
        String[][] array = {...};
        String[][] expected = {...};

        String[][] result = Sort.findRanks(array, 11, 12);

        assertArrayEquals(expected, result);
    }
}