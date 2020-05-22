import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;

public class DummyTest{

    @Test
    public void someTest(){

        final Collection<Integer> coll = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(coll, hasItems(5, 4, 3, 2, 1));
        assertThat(coll, not(hasItems(6)));
        assertThat(coll,
            both(
                is(List.class)
            ).and(
                equalTo(
                    Arrays.asList(
                        0x1,0x2,0x3,0x4,0x5
                    )
            )
        ));

    }



}