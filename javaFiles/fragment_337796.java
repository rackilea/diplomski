import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import io.jachoteam.taxiapp.views.WaitingIndicatorView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class ExampleUnitTest {

    @Test
    public void getHoursMinutesSeconds_isCorrect1() {
        String actualValue = WaitingIndicatorView.getHoursMinutesSeconds(1);
        assertThat(actualValue, is(equalTo("00:00:01")));
    }

    @Test
    public void getHoursMinutesSeconds_isCorrect2() {
        String actualValue = WaitingIndicatorView.getHoursMinutesSeconds(60);
        assertThat(actualValue, is(equalTo("00:01:00")));
    }
}