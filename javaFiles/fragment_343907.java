import com.google.common.collect.FluentIterable;
import com.google.common.truth.*;
import org.hamcrest.*;
import org.junit.Test;

import java.util.*;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.common.truth.Truth.assert_;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExactlyOneInstanceTest {
    List<Object> myList = Arrays.asList("", 3, 'A', new Object());

    @Test
    public void hamcrestBuiltInTestExactlyOneInstance() {
        long theNumberOfStringsInMyList = myList.stream().filter(o -> o instanceof String).count();
        assertThat(theNumberOfStringsInMyList, equalTo(1L));
    }

    @Test
    public void hamcrestExtendedTestExactlyOneInstance() {
        assertThat(myList, HasExactlyOne.itemThat(is(instanceOf(String.class))));
    }

    @Test
    public void truthBuiltInTestExactlyOneInstance() {
        long theNumberOfStringsInMyList = myList.stream().filter(o -> o instanceof String).count();
        // can't static import Truth.assertThat because of name clash,
        // but we can use this alternative form
        assert_().that(theNumberOfStringsInMyList).isEqualTo(1);
    }

    @Test
    public void truthExtendedTestExactlyOneInstance() {
        assertAbout(iterable()).that(myList).containsExactlyOneInstanceOf(String.class);
    }


    // Hamcrest custom matcher
    static class HasExactlyOne<T> extends TypeSafeDiagnosingMatcher<Iterable<? super T>> {
        Matcher<? super T> elementMatcher;

        HasExactlyOne(Matcher<? super T> elementMatcher) {
            this.elementMatcher = elementMatcher;
        }

        @Factory
        public static <T> Matcher<Iterable<? super T>> itemThat(Matcher<? super T> itemMatcher) {
            return new HasExactlyOne<>(itemMatcher);
        }

        @Override
        public void describeTo(Description description) {
            description
                .appendText("a collection containing exactly one item that ")
                .appendDescriptionOf(elementMatcher);
        }

        @Override
        protected boolean matchesSafely(Iterable<? super T> item, Description mismatchDescription) {
            return FluentIterable.from(item).filter(o -> elementMatcher.matches(o)).size() == 1;
        }
    }

    // Truth custom extension
    static <T> SubjectFactory<ExtendedIterableSubject<T>, Iterable<T>> iterable() {
        return new SubjectFactory<ExtendedIterableSubject<T>, Iterable<T>>() {
            @Override
            public ExtendedIterableSubject<T> getSubject(FailureStrategy fs, Iterable<T> target) {
                return new ExtendedIterableSubject<>(fs, target);
            }
        };
    }

    static class ExtendedIterableSubject<T> extends IterableSubject<ExtendedIterableSubject<T>, T, Iterable<T>> {
        ExtendedIterableSubject(FailureStrategy failureStrategy, Iterable<T> list) {
            super(failureStrategy, list);
        }

        void containsExactlyOneInstanceOf(Class<?> clazz) {
            if (FluentIterable.from(getSubject()).filter(clazz).size() != 1) {
                fail("contains exactly one instance of", clazz.getName());
            }
        }
    }
}