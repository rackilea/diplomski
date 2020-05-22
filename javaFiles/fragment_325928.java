import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/**
 * Test simple functionality of the Map is sound.
 *
 * Created by James on 28/02/2017.
 */
public class SynchronizedLongMultimapTest {

    private final SynchronizedLongMultimap<String, String> map = new SynchronizedLongMultimap<>();

    @Test
    public void addAndGet_SingleCell() {
        // add and get sets the initial value to the delta
        assertThat(map.addAndGet("0", "0", 1), equalTo(1L));
        assertThat(map.addAndGet("0", "0", 1), equalTo(2L));
        assertThat(map.addAndGet("0", "0", 0), equalTo(2L));
        assertThat(map.addAndGet("0", "0", -2), equalTo(0L));
    }
    @Test
    public void addAndGet_RangeCells() {
        // add and get sets the initial value to the delta
        assertThat(map.addAndGet("0", "1", 123), equalTo(123L));

        // add and get sets the initial value to the delta
        assertThat(map.addAndGet("1", "1", 42), equalTo(42L));
        // add and get adds the delta to the existing value
        assertThat(map.addAndGet("1", "1", -42), equalTo(0L));
    }

    @Test
    public void increment() {
        // increment sets the initial value to one
        assertThat(map.increment("0", "0"), equalTo(1L));
        // then adds one each time it's called
        assertThat(map.increment("0", "0"), equalTo(2L));
    }

    @Test
    public void decrement(){
        // decrement sets the initial value to -1 if no previous value
        assertThat(map.decrement("apples", "bananas"), equalTo(-1L));
        // then decrements that
        assertThat(map.decrement("apples", "bananas"), equalTo(-2L));
    }

    @Test
    public void get_PreviousValueIsNull() {
        assertThat(map.get("toast", "bananas"), equalTo(null));
        // even if we ask again
        assertThat(map.get("toast", "bananas"), equalTo(null));
    }

    @Test
    public void get_ProvidedByPut() {
        assertThat(map.put("toast", "corn flakes", 17L), equalTo(null));
        // then we get what we put in
        assertThat(map.get("toast", "corn flakes"), equalTo(17L));
    }

    @Test
    public void get_ColumnMap() {
        // Expected behaviour from MultiKeyMap question
        assertThat(map.put("a", "A", 1L), equalTo(null));
        assertThat(map.put("a", "B", 2L), equalTo(null));
        assertThat(map.put("b", "C", 3L), equalTo(null));

        // then we can get a single value
        assertThat(map.get("a", "A"), equalTo(1L));
        // or a Map
        assertThat(map.get("a"), equalTo(ImmutableMap.of("A", 1L, "B", 2L)));
        // even if that Map only has a single value
        assertThat(map.get("b"), equalTo(ImmutableMap.of("C", 3L)));
    }
}