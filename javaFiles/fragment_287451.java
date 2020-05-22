import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.os.prodefacto.StackoverflowDemo;

class StreamTest {

    @Test
    void test() {
        // provide a list that contains dpulicates (input value)
        List<String> input = new ArrayList<String>();
        input.add("AAA");
        input.add("BBB");
        input.add("CCC");
        input.add("AAA");
        input.add("DDD");
        input.add("EEE");
        input.add("AAA");
        input.add("BBB");
        input.add("FFF");
        input.add("GGG");

        // provide an expected result
        List<String> expected = new ArrayList<String>();
        expected.add("AAA");
        expected.add("BBB");
        expected.add("CCC");
        expected.add("DDD");
        expected.add("EEE");
        expected.add("FFF");
        expected.add("GGG");

        // get the actual value of the (static) method with the input as argument
        List<String> actual = StackoverflowDemo.getDistinctValuesFrom(input);
        // assert the result of the test (here: equal)
        assertEquals(expected, actual);
    }
}