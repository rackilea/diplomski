public class MyExceptionMatcher extends TypeSafeMatcher<MyException> {
    private final IntPredicate predicate;

    public MyExceptionMatcher(IntPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    protected boolean matchesSafely(MyException item) {
        return predicate.test(item.n);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("my exception which matches predicate");
    }
}