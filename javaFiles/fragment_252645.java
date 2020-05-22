import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestClassSample {
    private volatile AtomicInteger counter = new AtomicInteger(1);

    @CanRunMultipleTimes
    @Test
    public void testMethod() {
        System.err.println("Running iteration [" + counter.getAndIncrement() + "]");
    }
}