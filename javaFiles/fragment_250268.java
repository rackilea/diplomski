import javax.inject.Inject;

public class ServiceA {

    @Inject
    ServiceB serviceB;

    public void methodA() {
        serviceB.methodB();
    }
}

import javax.inject.Inject;

public class ServiceB {

    @Inject
    Logger log;

    public void methodB() {
        log.debug("log message");
    }
}

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

public class ServiceTest {

    /**
     * Create an instance of the class ServiceA.
     */
    @InjectMocks
    private ServiceA serviceA;

    /**
     * Create a fake instance of ServiceB.
     */
    @Mock
    private ServiceB serviceB;

    /**
     * Create a fake instance of Logger.
     */
    @Mock
    private Logger log;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Verify that methodB is called.
     */
    @Test
    public void testServiceA() {
        serviceA.methodA();
        verify(serviceB, times(1)).methodB();
    }
}