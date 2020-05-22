import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.*;
import static org.junit.rules.ExpectedException.none;

public class XTest {

    @Rule
    public final ExpectedException thrown = none();

    @Test
    public void any() {
        thrown.expect(
                hasCause(hasCause(instanceOf(RuntimeException.class))));
        throw new RuntimeException(
                new RuntimeException(
                        new RuntimeException("dummy message")
                )
        );
    }

    private Matcher hasCause(Matcher matcher) {
        return Matchers.hasProperty("cause", matcher);
    }
}