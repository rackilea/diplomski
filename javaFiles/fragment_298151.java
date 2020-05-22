import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.powermock.reflect.Whitebox;

@PrepareForTest(ClassUnderTest.class)
public class MockLog4JTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @BeforeClass
    public static void oneTimeSetup() {
        System.setProperty("log4j.defaultInitOverride", Boolean.toString(true));
        System.setProperty("log4j.ignoreTCL", Boolean.toString(true));
    }

    @Test
    public void testLog()
    {
        ClassUnderTest classUnderTest = new ClassUnderTest();
        Logger mockLogger = mock(Logger.class);

        Whitebox.setInternalState(ClassUnderTest.class, "logger", mockLogger);

        classUnderTest.run();

        verify(mockLogger).info(eq("Hello."));
    }
}