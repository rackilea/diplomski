import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final String[] split1 = "code|e|0.07610 |o| p|e|0.02225 |o| li|e|0.02032 |o| applet|e|0.01305 |o| pre|e|0.01289".split(Pattern.quote(" |o| "));

        for (int i = 0; i < split1.length; ++i) {
            final String name = split1[i];
            final String[] split2 = name.split(Pattern.quote("|e|"));

            for (int j = 0; j < split2.length; ++j) {
                System.out.println(split2[j]);
            }

            System.out.println("");
        }
    }
}