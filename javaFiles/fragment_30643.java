import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ArgumentCaptorTest {

    private static class Order {
    }

    public static class OrderDAO {
        public Order read(Integer any) {
            return null;
        }
    }

    @Mock
    OrderDAO dao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void captor_A() {
        Order order = new Order();
        ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);
        when(dao.read(any(Integer.class))).thenReturn(order);
        dao.read(123);
        dao.read(456);
        verify(dao, times(2)).read(intCaptor.capture());
        assertThat(intCaptor.getAllValues(), hasItems(456));
    }
}