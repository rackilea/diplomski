import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class FooTest {
    @Test
    public void test() {
        List<Foo> foos = Arrays.asList(new Foo());

        assertThat(foos,
                Matchers.<Foo>hasItem(Matchers.hasProperty("bar", Matchers.equalTo("some value"))));
    }
}