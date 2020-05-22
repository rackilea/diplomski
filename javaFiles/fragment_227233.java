@Service
class OrderUtil {
    private static final AtomicBoolean dynamicValue = new AtomicBoolean();

    public boolean isDynamicValue() {
        return dynamicValue.get();
    }

    public void setDynamicValue(boolean v) {
        dynamicValue.set(v);
    }

    //think about it https://en.wikipedia.org/wiki/Compare-and-swap
    public boolean casDynamicValue(boolean expect, boolean update) {
        return dynamicValue.compareAndSet(expect, update);
    }
}