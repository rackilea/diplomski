package de.scrum_master.aspect;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import de.scrum_master.app.Application;

public class SampleAspectIT {
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    private Application application = new Application();

    private PrintStream originalSystemOut;
    @Mock private PrintStream fakeSystemOut;

    @Before
    public void setUp() throws Exception {
        originalSystemOut = System.out;
        System.setOut(fakeSystemOut);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalSystemOut);
    }

    @Test
    public void testPositiveSmallNumber() throws Throwable {
        application.doSomething(11);
        verify(System.out, times(1)).println(matches("execution.*doSomething.* 11"));
        verify(System.out, times(1)).println(matches("Doing something with number 11"));
    }

    @Test
    public void testNegativeNumber() throws Throwable {
        application.doSomething(-22);
        verify(System.out, times(1)).println(matches("execution.*doSomething.* -22"));
        verify(System.out, times(1)).println(matches("Doing something with number 22"));
    }

    @Test(expected = RuntimeException.class)
    public void testPositiveLargeNumber() throws Throwable {
        try {
            application.doSomething(333);
        }
        catch (Exception e) {
            verify(System.out, times(1)).println(matches("execution.*doSomething.* 333"));
            verify(System.out, times(0)).println(matches("Doing something with number"));
            assertEquals("oops", e.getMessage());
            throw e;
        }
    }
}