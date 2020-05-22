import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Calculates the logical negation of a matcher.
 */
public class IsNotDescribing<T> extends BaseMatcher<T>  {
    private final Matcher<T> matcher;

    public IsNotDescribing(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Object arg) {
        return !matcher.matches(arg);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("not ").appendDescriptionOf(matcher);
    }

    // use the matcher to describe its mismatch
    @Override
    public void describeMismatch(Object item, Description description) {
        matcher.describeMismatch(item, description);
    }

    @Factory
    public static <T> Matcher<T> notD(Matcher<T> matcher) {
        return new IsNotDescribing<T>(matcher);
    }

    @Factory
    public static <T> Matcher<T> notD(T value) {
        return notD(equalTo(value));
    }
}