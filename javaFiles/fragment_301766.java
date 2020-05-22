final class Value<T> {

    private static final Value<?> noValue = new Value<>(State.NO_VALUE, null);
    private static final Value<?> undefined = new Value<>(State.UNDEFINED, null);

    private enum State {

        VALUE,
        NO_VALUE,
        UNDEFINED

    }

    private final State state;
    private final T value;

    private Value(final State state, final T value) {
        this.value = value;
        this.state = state;
    }

    static <T> Value<T> value(final T value) {
        if ( value == null ) {
            return noValue();
        }
        return new Value<>(State.VALUE, value);
    }

    static <T> Value<T> noValue() {
        @SuppressWarnings("unchecked")
        final Value<T> value = (Value<T>) noValue;
        return value;
    }

    static <T> Value<T> undefined() {
        @SuppressWarnings("unchecked")
        final Value<T> value = (Value<T>) undefined;
        return value;
    }

    T getValue()
            throws IllegalStateException {
        if ( state != State.VALUE ) {
            throw new IllegalStateException("Can't provide value for " + state);
        }
        return value;
    }

    boolean isValue() {
        return state == State.VALUE;
    }

    boolean isNoValue() {
        return state == State.NO_VALUE;
    }

    boolean isUndefined() {
        return state == State.UNDEFINED;
    }

    @Override
    public String toString() {
        if ( state != State.VALUE ) {
            return state.toString();
        }
        return Objects.toString(value);
    }

}