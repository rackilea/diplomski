import static java.lang.System.in;
import static java.lang.System.out;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Music {

    private static final String DEFAULT_MUSIC = "Country";

    public static void main(String[] args) {
        Map<Integer, String> musicOptions = new LinkedHashMap<Integer, String>();
        musicOptions.put(1, DEFAULT_MUSIC);
        musicOptions.put(2, "Rock");
        musicOptions.put(3, "Heavy Metal");
        musicOptions.put(4, "Folk");

        out.println("What's your favorite kind music?: ");
        for (Entry<Integer, String> option : musicOptions.entrySet()) {
            Integer choice = option.getKey();
            String music = option.getValue();

            out.printf("%d. %s\n", choice, music);
        }

        final int choice = new Scanner(in).nextInt();
        String music = musicOptions.get(choice);
        if (music == null) {
            music = DEFAULT_MUSIC;
        }

        out.println(music);
    }

}