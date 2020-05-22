import net.java.quickcheck.Generator;
import static net.java.quickcheck.generator.PrimitiveGenerators.characters;

public class MyCharacterGenerator implements Generator<String> {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = ".-\\;:_@[]^/|}{";
    private static final String ALL_MY_CHARS = LOWERCASE_CHARS
            + UPPERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
    public static final int CAPACITY = 40;

    Generator<Character> characterGenerator = characters(ALL_MY_CHARS);

    public String generate() {
        StringBuilder sb = new StringBuilder(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            sb.append(characterGenerator.next());
        }
        return sb.toString();
    }

    @Override
    public String next() {
        return generate();
    }
}