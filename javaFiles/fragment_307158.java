import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.EnumSet;

import org.junit.Test;

public class TempTest {

    @Test
    public void x() {
        EnumSet<Colors> allColors = EnumSet.allOf(Colors.class);
        assertEquals(4, allColors.size());
        assertThat(allColors, contains(Colors.Yellow, Colors.Blue, Colors.Orange, Colors.Green));
        for (Colors c : allColors) {
            System.out.println(c.name() + " (" + c.getDescription() + ")");
        }
    }
}