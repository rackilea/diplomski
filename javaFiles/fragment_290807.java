import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

assertThat("timestamp",
           Long.parseLong(previousTokenValues[1]),
           greaterThan(Long.parseLong(currentTokenValues[1])));