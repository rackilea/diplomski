import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestCenter {
    @Test
    public void centersString() {
        assertThat(StringUtils.center(null, 0), equalTo(null));
        assertThat(StringUtils.center("foo", 3), is("foo"));
        assertThat(StringUtils.center("foo", -1), is("foo"));
        assertThat(StringUtils.center("moon", 10), is("   moon   "));
        assertThat(StringUtils.center("phone", 14, '*'), is("****phone*****"));
        assertThat(StringUtils.center("India", 6, '-'), is("India-"));
        assertThat(StringUtils.center("Eclipse IDE", 21, '*'), is("*****Eclipse IDE*****"));
    }

    @Test
    public void worksWithFormat() {
        String format = "|%1$-10s|%2$-10s|%3$-20s|\n";
        assertThat(String.format(format, StringUtils.center("FirstName", 10), StringUtils.center("Init.", 10), StringUtils.center("LastName", 20)),
                is("|FirstName |  Init.   |      LastName      |\n"));
    }
}

class StringUtils {

    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }
}