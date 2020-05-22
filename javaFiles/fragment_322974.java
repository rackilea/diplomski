package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class SampleAspectTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ProceedingJoinPoint proceedingJoinPoint;

    private SampleAspect sampleAspect = new SampleAspect();

    @Test
    public void testPositiveSmallNumber() throws Throwable {
        sampleAspect.intercept(proceedingJoinPoint, 11);
        // 'proceed()' is called exactly once
        verify(proceedingJoinPoint, times(1)).proceed();
        // 'proceed(Object[])' is never called
        verify(proceedingJoinPoint, never()).proceed(null);
    }

    @Test
    public void testNegativeNumber() throws Throwable {
        sampleAspect.intercept(proceedingJoinPoint, -22);
        // 'proceed()' is never called
        verify(proceedingJoinPoint, never()).proceed();
        // 'proceed(Object[])' is called exactly once
        verify(proceedingJoinPoint, times(1)).proceed(new Object[] { 22 });
    }

    @Test(expected = RuntimeException.class)
    public void testPositiveLargeNumber() throws Throwable {
        sampleAspect.intercept(proceedingJoinPoint, 333);
    }
}