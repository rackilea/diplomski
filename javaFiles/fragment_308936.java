import java.lang.reflect.Field;
import java.time.Instant;
import java.util.TimeZone;

public class SimpleTest {

    public static void main(String[] args) {
        TimeZone tz = TimeZone.getTimeZone("America/Caracas");

        Field f = null;
        try {
            f = tz.getClass().getDeclaredField("transitions");
            f.setAccessible(true);
            long[] transitions = (long[]) f.get(tz);
            f = tz.getClass().getDeclaredField("offsets");
            f.setAccessible(true);
            int[] offsets = (int[]) f.get(tz);

            for ( long transition : transitions ) {
                Instant transitionInstant = Instant.ofEpochMilli(transition >> 12);
                int offset = offsets[(int)transition & 0xF];
                System.out.println( transitionInstant + " : " + offset);
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}