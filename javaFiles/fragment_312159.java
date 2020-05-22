public class FooComparator implements Comparator<Foo> {
    @Override
    public int compare(Foo f1, Foo f2) {
        int result = Float.compare(f1.getFloatValue(), f2.getFloatValue());
        if (result == 0) {
            result = f1.getStringValue().compareTo(f2.getStringValue());
        }
        return result;
    }
}