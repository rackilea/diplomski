import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(com.dnb.cirrus.core.authentication.TestableTest.Testable.class)

public class TestableTest {
    public static class Testable {
        public void a() {
            b();
            c();
            d();
            e();
        }
        public void b() {
        }
        public static void c() {
        }
        private void d() {
        }
        private static void e() {
        }
    }

    Testable testable;

    // Verify that public b() is called from a()
    @Test
    public void testB() {
        testable = Mockito.spy(new Testable());
        testable.a();
        Mockito.verify(testable).b();
    }
    // Verify that public static c() is called from a()
    @Test
    public void testC() throws Exception {
        PowerMockito.mockStatic(Testable.class);
        testable = new Testable();
        testable.a();
        PowerMockito.verifyStatic();
        Testable.c();
    }
    // Verify that private d() is called from a()
    @Test
    public void testD() throws Exception {
        testable = PowerMockito.spy(new Testable());
        testable.a();
        PowerMockito.verifyPrivate(testable).invoke("d");
    }
    // Verify that private static e() is called from a()
    @Test
    public void testE() throws Exception {
        PowerMockito.mockStatic(Testable.class);
        testable = new Testable();
        testable.a();
        PowerMockito.verifyPrivate(Testable.class).invoke("e");
    }
}