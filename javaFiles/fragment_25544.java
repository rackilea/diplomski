public class CapturingAnswer<T, R> implements Answer<T> {

    private final Function<InvocationOnMock, R> capturingFunction;

    private final List<R> capturedValues = new ArrayList<R>();

    public CapturingAnswer(final Function<InvocationOnMock, R> capturingFunction) {
        super();
        this.capturingFunction = capturingFunction;
    }

    @Override
    public T answer(final InvocationOnMock invocation) throws Throwable {
        capturedValues.add(capturingFunction.apply(invocation));
        return null;
    }

    public List<R> getCapturedValues() {
        return Collections.unmodifiableList(capturedValues);
    }

}