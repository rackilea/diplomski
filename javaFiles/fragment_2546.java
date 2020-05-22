import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import static org.junit.Assert.assertTrue;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class MyCharacterGeneratorTest {

    @Theory
    public void shouldHold(@ForAll @From(MyCharacterGenerator.class) String s) {
        // here you should add your unit test which uses the generated output
        // 
        // assertTrue(doMyUnitTest(s) == expectedResult);

        // the below lines only for demonstration and currently
        // check that the generated random has the expected
        // length and matches the expected pattern
        System.out.println("shouldHold(): " + s);
        assertTrue(s.length() == MyCharacterGenerator.CAPACITY);
        assertTrue(s.matches("[a-zA-Z0-9.\\-\\\\;:_@\\[\\]^/|}{]*"));
    }
}