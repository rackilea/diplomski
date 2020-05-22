import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class List {

    private int value;
    private List next;

    public static final List EMPTY = new List(-1, null) {
        public List remove(int n) { return this; };
        public String toString() { return ""; };
    };

    public List(int value, List next) {
        this.value = value;
        this.next = next;
    }

    public List remove(int n) {
        if (value == n) return next;
        return new List(value,next.remove(n));
    }   

    public String toString() {
        return value + "," + next.toString();
    }

    public static class Examples {

        @Test
        public void shouldRemoveElement() {
            List l = new List(1, new List(2, new List(2, new List(3, EMPTY))));
            assertEquals("1,2,2,3,",l.toString());
            assertEquals("2,2,3,",l.remove(1).toString());
            assertEquals("1,2,3,",l.remove(2).toString());
            assertEquals("1,2,2,",l.remove(3).toString());
            assertEquals("1,2,2,3,",l.toString());
        }

    }

}