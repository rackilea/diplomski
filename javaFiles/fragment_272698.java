import org.hibernate.exception.ConstraintViolationException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;


public class MyTest {
    @Mock /* service mock */
    private MyService myService;

    @InjectMocks /* inject the mocks in the object under test */
    private ServiceCaller serviceCaller;

    @Test
    public void shouldHandleConstraintViolation() {
        // make the mock throw the exception when called
        when(myService.someMethod(...)).thenThrow(new ConstraintViolationException(...))

        // get the operation result
        MyResult result = serviceCaller.doSomeStuffWhichInvokesTheServiceMethodThrowingConstraintViolation();

        // verify all went according to plan
        assertWhatever(result);
    }
}