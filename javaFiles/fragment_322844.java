import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import junit.framework.TestCase;

public class FooTest extends TestCase{
    Mockery context = new JUnit4Mockery();

    public interface Foo {
        public abstract <T> void bar(Class<? extends T> paramClass, T paramT);
    }

    public static class Snafu {}

    public void testFoo() {
        final Foo mock = context.mock(Foo.class);
        context.checking(new Expectations() {
            // keep warnings close to the culprit code when possible
            @SuppressWarnings("unchecked")
            public void allow(final Foo mockedFoo) {
                allowing(mockedFoo).bar(
                        with(any(Class.class)), // Matcher that *should* resolve to Class<?>
                        with(any(Snafu.class)));  // matcher to anything of type Snafu.class
            }
            {
                allow(mock);
            }
        });

        // test bar method (two invocations)
        mock.bar(Snafu.class, someStaticFunctionThatReturnsASnafu());
        mock.bar(Snafu.class, someStaticFunctionThatReturnsASnafu());

    }

    public static Snafu someStaticFunctionThatReturnsASnafu() {
        return new Snafu();
    }
}