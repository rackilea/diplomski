@RunWith(Parameterized.class)
public class MaxInArrayTest {

    private static class ArrayAndExpectedMax {
        private int[] array;
        private int expectedMax;

        public ArrayAndExpectedMax(int[] array, int expectedMax) {
            this.array = array;
            this.expectedMax = expectedMax;
        }

        public int[] getArray() {
            return array;
        }

        public int getExpectedMax() {
            return expectedMax;
        }
    }

    @Parameterized.Parameter
    public ArrayAndExpectedMax param;

    @Parameterized.Parameters
    public static Collection<ArrayAndExpectedMax> data(){
        return Arrays.asList(new ArrayAndExpectedMax(new int[] {1, 2, 3, 4}, 4),
                             new ArrayAndExpectedMax(new int[] {20, 30, 40, 50}, 50));
    }

    @Test
    public void testMaxInArray(){
        MaxInArray maxInArray = new MaxInArray();
        Assert.assertEquals(param.getExpectedMax(), maxInArray.findMax(param.getArray()));
    }
}