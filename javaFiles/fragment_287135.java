import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public class MockButton implements HasClickHandlers {

    private HandlerManager handlerManager = new HandlerManager(this);

    public void click() {
        handlerManager.fireEvent(new ClickEvent() {
        });
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return handlerManager.addHandler(ClickEvent.getType(), handler);
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

}