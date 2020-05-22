import static org.junit.Assert.*;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import static org.unitils.reflectionassert.ReflectionAssert.*;
import java.util.Arrays;
import java.util.List;

public class ReflectionEqualsTest {

    public static class A {
        private String x;

        public A(String text) {
            this.x = text;
        }
    }

    @Test
    public void testCompareListsOfObjectsWithoutEqualsImplementation() throws Exception {
        List<A> list = Arrays.asList(new A("1"), new A("2"));
        List<A> equalList = Arrays.asList(new A("1"), new A("2"));
        List<A> listInDifferentOrder = Arrays.asList(new A("2"), new A("1"));

        assertNotEquals(list, equalList);
        assertNotEquals(list, listInDifferentOrder);

        assertReflectionEquals(list, equalList);
        assertReflectionEquals(list, listInDifferentOrder, 
                        ReflectionComparatorMode.LENIENT_ORDER);
    }
}