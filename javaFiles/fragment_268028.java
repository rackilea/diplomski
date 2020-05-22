import static org.powermock.api.mockito.PowerMockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Blub.class)
public class Mockexample {

@Test
public void test() {
    Blub blub = PowerMockito.mock(Blub.class);
    final List<Integer> counter = Arrays.asList(1, 2, 3);
    final AtomicInteger i = new AtomicInteger(0);

    // blub.size() is final, only reason to use PowerMockito here
    when(blub.size()).thenAnswer(new Answer<Integer>() {

        @Override
        public Integer answer(InvocationOnMock invocation) throws Throwable {
            return counter.get(i.getAndIncrement());
        }

    });
    System.out.println(blub.size());
    System.out.println(blub.size());
    System.out.println(blub.size());
}

}