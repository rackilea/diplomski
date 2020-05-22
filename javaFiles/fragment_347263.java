import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Ring {

    private String[] data;
    int n = 0;

    public Ring(int size) {
        data = new String[size];
    }

    public void push(String s) {
        data[n] = s;
        n = (n + 1) % data.length;
    }

    public void shift(String s) {
        data[n = (n - 1) % data.length] = s;
    }

    public String get(int index) {
        return data[(n + index) % data.length];
    }

    public static class Examples {

        @Test
        public void shouldDropElementsWhenPushingTooFar() {
            Ring ring = new Ring(3);
            ring.push("A");
            ring.push("B");
            ring.push("C");
            ring.push("D");
            ring.push("E");
            assertEquals("C", ring.get(0));
            assertEquals("D", ring.get(1));
            assertEquals("E", ring.get(2));
        }

        @Test
        public void shouldAddElementsAtTheFront() {
            Ring ring = new Ring(3);
            ring.push("A");
            ring.push("B");
            ring.push("C");
            ring.push("D");
            ring.push("E");
            // rewind
            ring.shift("B");
            assertEquals("B", ring.get(0));
            assertEquals("C", ring.get(1));
            assertEquals("D", ring.get(2));
        }

    }

}