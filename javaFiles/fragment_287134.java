import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public class ResultPresenter {

    private Display display;

    public interface Display {
        HasClickHandlers getShowResultButton();
        HasText getResultLabel();
    }

    public void bind(final Display display) {
        this.display = display;
        display.getShowResultButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showResult();
            }
        });
    }

    public void showResult() {
        display.getResultLabel().setText("It works");
    }

}