import java.lang.reflect.Field;

public class Test {

    private static final class Widget {
        private final int val = 23;

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        Widget w = new Widget ();

        Field m = Widget.class.getDeclaredField("val");

        m.setAccessible(true);

        m.set(w, 233);

        Field m1 = Widget.class.getDeclaredField("val");
        m1.setAccessible(true);


        System.out.println(m.get(w)); /// PRINT 233
        System.out.println(w.getVal()); /// PRINT 23
        System.out.println(m1.get(w)); /// PRINT 233

    }
}