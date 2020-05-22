import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.IterableSubject;
import com.google.common.truth.SubjectFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.truth.Truth.assertAbout;
import static com.google.common.truth.Truth.assertThat;

public class ContainsAtLeastTest {
    List<Integer> haystack = ImmutableList.of(1, 2, 3, 1, 2, 3);

    @Test
    public void COUNT_YOURSELF_haystack_contains_at_least_two_needles() {
        // No built-in way to match-N elements, so you can match yourself then compare.
        // This is easier to implement initially, but doesn't look as nice and gives not-so-great failure messages.
        Set<Integer> needles = ImmutableSet.of(0, 1, 2);
        long theNumberOfContainedElements = haystack.stream().distinct().filter(needles::contains).count();
        assertThat(theNumberOfContainedElements).isAtLeast(2L);
    }

    @Test
    public void CUSTOM_PROPOSITION_haystack_contains_at_least_two_needles() {
        // If this is something that you test often, or if you just want the test to be more readable,
        // it could be worth adding your own match-N proposition.
        // You can word your own propositions however you like to maximize readability.
        // The assertAbout method is google-truth's hook into extending the built-in testing vocabulary.
        // You can define your own propositions by providing your own Subject class
        // (which is just a set of possible propositions about something) and a SubjectFactory.
        assertAbout(An.<Integer>iterable()).that(haystack).hasAtLeast(2).elementsFrom(1, 3, 5);
    }

    // Wrapping with "An" allows specifying the Iterable's generic type in a readable way.
    static class An {

        // assertAbout will use our factory that returns our own Subject
        static <T> SubjectFactory<ExtendedIterableSubject<T>, Iterable<T>> iterable() {
            return new SubjectFactory<ExtendedIterableSubject<T>, Iterable<T>>() {
                @Override
                public ExtendedIterableSubject<T> getSubject(FailureStrategy fs, Iterable<T> target) {
                    return new ExtendedIterableSubject<>(fs, target);
                }
            };
        }

        // We extend from IterableSubject so we don't lose the built-in vocabulary
        static class ExtendedIterableSubject<T> extends IterableSubject<ExtendedIterableSubject<T>, T, Iterable<T>> {
            ExtendedIterableSubject(FailureStrategy failureStrategy, Iterable<T> list) {
                super(failureStrategy, list);
            }

            // Alternatively, we could directly define a proposition hasAtLeastTwoOf(T... elements),
            // but it's nicer if min is a parameter.
            IterableWithMin hasAtLeast(int min) {
                return new IterableWithMin(min);
            }

            // Don't make this inner class extend Subject, because when starting with hasAtLeast(N),
            // the language of the test will only make sense if it's followed by a method defined here.
            // This keeps the API fluent by limiting the vocabulary.
            class IterableWithMin {
                int min;

                IterableWithMin(int min) {
                    this.min = min;
                }

                @SafeVarargs final void elementsFrom(T... instances) {
                    // The actual match-N translated into a fluent hasAtLeast(N).elementsFrom(e1, e2, ..., eM) form.
                    Set<T> instanceSet = newHashSet(instances);
                    long numContainedElements = StreamSupport.stream(getSubject().spliterator(), false).distinct().filter(instanceSet::contains).count();
                    if (numContainedElements < min) {
                        fail(String.format("contains at least %d elements from", min), Arrays.asList(instances));
                    }
                }
            }
        }
    }
}