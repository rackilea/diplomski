public class CommonClassAdapter implements MyAdapter {
    private final CommonClass common;
    private final String cachedResult;

    // Note that I'm doing dependency injection here
    public CommonClassAdapter(CommonClass common) {
        this.common = common;

        // Don't expose these because they shouldn't be called more than once
        common.methodIOnlyCallOnce();
        cachedResult = common.anotherMethodIOnlyCallOnce();
    }

    @Override
    public void someMethod() {
        common.someMethodWithDifferentName();
    }

    @Override
    public String dontRepeatYourself() {
        return cachedResult;
    }
}