import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;

public class FooBarTest {

    FooBar sut = new FooBar(); // System Under Test

    @Test
    public void shouldThrowExceptionWhenListHasTooManyElements() {

        when(sut).getMethod(listWithSize(150));

        then(caughtException()).isInstanceOf(Exception.class);
    }

    private List<String> listWithSize(int size) {
        return new ArrayList<String>(Arrays.asList(new String[size]));
    }
}