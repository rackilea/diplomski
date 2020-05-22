abstract class BaseLong {
    protected long value;

    public void setValue(final long value) throws YourControlException {
        if (checkValue(value)) {
            this.value = value;
        }
    }

    protected abstract void checkValue(final long value) throws YourControlException;
}

class UnsignedInteger extends BaseLong {
     @Override
    protected void checkValue(final long value) throws YourControlException {
        // Check if the value is ok for UnsignedInteger and throw as appropriate
    }
}

class Gauge32 extends BaseLong {
    @Override
    protected void checkValue(final long value) throws YourControlException {
        // Check if the value is ok for Gauge32 and throw as appropriate
    }
}