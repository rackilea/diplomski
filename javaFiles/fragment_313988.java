import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import okio.Buffer;

public class MoshiPrettyPrintingTest {

    private static class Dude {
        public final String firstName = "Jeff";
        public final String lastName = "Lebowski";
    }

    public static void main(String[] args) throws IOException {

        final Moshi moshi = new Moshi.Builder().build();

        final Buffer buffer = new Buffer();
        final JsonWriter jsonWriter = JsonWriter.of(buffer);

        // This is the important part:
        // - by default this is `null`, resulting in no pretty printing
        // - setting it to some value, will indent each level with this String
        // NOTE: You should probably only use whitespace here...
        jsonWriter.setIndent("    ");

        moshi.adapter(Dude.class).toJson(jsonWriter, new Dude());

        final String json = buffer.readUtf8();

        System.out.println(json);
    }
}