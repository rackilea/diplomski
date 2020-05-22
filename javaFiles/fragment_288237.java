import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoTest {

    @Test
    public void mockJdbcTemplate() {
        JdbcTemplate mockTemplate = Mockito.mock(JdbcTemplate.class);

        List<Map<String, Object>> mockResult = new ArrayList<>();

        Mockito.when(mockTemplate.queryForList(Mockito.anyString(), ArgumentMatchers.<Object>any())).thenReturn(mockResult);
        // Alternatively:
        // when(mockTemplate.queryForList(anyString(), Mockito.<Object>any())).thenReturn(mockResult);

        String query = "some query";
        Object[] params = new Object[]{1};

        List<Map<String, Object>> returnedResult = mockTemplate.queryForList(query, params);

        Assert.assertThat(returnedResult, CoreMatchers.sameInstance(mockResult));
    }

}