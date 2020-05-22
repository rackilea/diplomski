import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GsonTest {

    private static class Test1213 {

        public Test1213(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    void testConversion() throws IOException {
        Gson gson = new Gson();
        Test1213 john_doe1 = new Test1213("John Doe");
        String john_doe = gson.toJson(john_doe1);
        System.out.println(john_doe);
        Test1213 test1213 = gson.fromJson(john_doe, Test1213.class);
        assertThat(john_doe1.getName(), is(test1213.getName()));
    }
}