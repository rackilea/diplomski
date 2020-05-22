import static org.mockito.BDDMockito.*;
import org.junit.Test;
import com.google.gwt.user.client.ui.HasText;

public class ResultPresenterTest {

    @Test
    public void shouldSetItWorksResultText() {
        // given
        ResultPresenter.Display display = mock(ResultPresenter.Display.class);
        MockButton button = new MockButton();
        HasText label = mock(HasText.class);
        given(display.getShowResultButton()).willReturn(button);
        given(display.getResultLabel()).willReturn(label);
        ResultPresenter presenter = new ResultPresenter();
        presenter.bind(display);

        // when
        button.click();

        // then
        verify(label).setText("It works");
    }

}