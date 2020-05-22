public class ArrayToStringHelper {
    Object[] arrayData;
    public ArrayToStringHelper(Object[] arrayData) {
        this.arrayData = arrayData;
    }
    @Override
    public String toString() {
        return Arrays.deepToString(arrayData);
    }
}