public class DoubleColumn extends Column<Number> {
    @Override
    public Double getValue(int index) {
        return super.getValue(index).doubleValue();
    }
}