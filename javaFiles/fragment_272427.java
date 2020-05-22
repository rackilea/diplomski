import net.java.quickcheck.Generator;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class MyCharacterGeneratorTest {

    @Test
    public void testStringGenerator() {
        Generator<String> fuzzyString = new MyCharacterGenerator();

        for (int i = 0; i < 10; i++) {
            String fuzzy = fuzzyString.next();
            System.out.println("fuzzy: " + fuzzy);
            assertTrue(fuzzy.length() == MyCharacterGenerator.CAPACITY);
            assertTrue(fuzzy.matches("[a-zA-Z0-9.\\-\\\\;:_@\\[\\]^/|}{]*"));
        }
    }
}