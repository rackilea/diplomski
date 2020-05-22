import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class JUnitTest {

    @Test public void test1() {
        System.out.println("Test");
    }

    @BeforeEach public void f(TestInfo info) {
        System.out.println(info.getDisplayName());
    }
}