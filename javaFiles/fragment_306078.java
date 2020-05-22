import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FooTest {

    @Test
    public void foo() {
        String line = "FNAME:John:LNAME:Doe:AGE:40:DOB:July 31, 1975";

        final String[] split = line.split(":");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i % 2 != 0) {
                builder.append(split[i]);
                if (i != split.length -1) {
                    builder.append(" ");
                }
            }
        }
        assertThat(builder.toString(), is(equalTo("John Doe 40 July 31, 1975")));
    }
}