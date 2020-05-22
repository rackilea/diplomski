import java.io.BufferedReader;
import java.io.IOException;

[...]

public static String readNextWord(BufferedReader reader) throws IOException {
    StringBuilder builder = new StringBuilder();

    int currentData;

    do {
        currentData = reader.read();

        if(currentData < 0) {
            if(builder.length() == 0) {
                return null;
            }
            else {
                return builder.toString();
            }
        }
        else if(currentData != ' ') {
            /* Since you're talking about words, here you can apply
             * a filter to ignore chars like ',', '.', '\n', etc. */

            builder.append((char) currentData);
        }

    } while (currentData != ' ' || builder.length() == 0);

    return builder.toString();
}