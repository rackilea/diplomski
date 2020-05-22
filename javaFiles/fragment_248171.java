public interface HasDoubleValue{
    double doubleValue();
}

final class IntegerHasDoubleValueAdapter implements HasDoubleValue {
    private final Integer i;

    public IntegerHasDoubleValueAdapter(Integer i) {
        this.i = i;
    }

    @Override
    public double doubleValue() {
        return i.doubleValue();
    }
}

class Data<O extends HasDoubleValue> {
    void put(O o) {}

    public static void main(String[] args) {
        Integer i = 42;

        Data<IntegerHasDoubleValueAdapter> d1 = new Data<>();
        d1.put(new IntegerHasDoubleValueAdapter(i));

        Data<HasDoubleValue> d2 = new Data<>();
        d2.put(() -> i.doubleValue());

        Data<HasDoubleValue> d3 = new Data<>();
        d3.put(i::doubleValue);
    }
}