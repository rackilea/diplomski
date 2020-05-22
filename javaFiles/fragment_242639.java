public class StreamTest {
    public static void main(String[] args) {
        DataContainer dc = new DataContainer();
        BiPredicate<Integer, LimitValue> p = (t, limitValue) -> t > limitValue.getValue();
        System.out.println(dc.numberOfValuesGreaterThan(p, new LimitValue(6)));
    }

}

class DataContainer {
    private int[] l = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    long numberOfValuesGreaterThan(BiPredicate<Integer, LimitValue> predicate, LimitValue lv) {
        return IntStream.of(l)
                .filter(t -> predicate.test(t, lv))
                .count();
    }
}

class LimitValue {
    private int limitValue;

    LimitValue(int limitValue) {
        this.limitValue = limitValue;
    }

    int getValue() {
        return limitValue;
    }
}