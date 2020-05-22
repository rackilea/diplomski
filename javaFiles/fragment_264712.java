import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(A.class)
public class ATest {

    A testableA = new A();

    @Test
    public void testMethod1() throws Exception {
        B bMock = EasyMock.createNiceMock(B.class);
        PowerMock.expectNew(B.class).andReturn(bMock).anyTimes();
        EasyMock.expect(bMock.method2()).andReturn(new C()).anyTimes();
        PowerMock.replay(B.class);
        EasyMock.replay(bMock);

        testableA.method1();

        //assert and validate your scenario here
    }
}