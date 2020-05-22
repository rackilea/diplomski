public class TestRangeFactory {

    public static void main(String[] args) {
        for (int i : RangeFactory.range(1, 10)) {
            System.out.println(i);
        }
    }

}