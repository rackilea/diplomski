import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.History;

public class BackPreviewHandler implements NativePreviewHandler {

    private HandlerRegistration handlerRegistration;

    @Override
    public void onPreviewNativeEvent(final NativePreviewEvent event) {
        if (event.getTypeInt() == Event.ONKEYDOWN) {
            if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_BACKSPACE) {
                Element elemPointedByMouse = Element.as(event.getNativeEvent().getEventTarget());
                String tagName = elemPointedByMouse.getTagName();
                System.out.println(tagName);

                if (!tagName.equalsIgnoreCase("INPUT") 
                        && !tagName.equalsIgnoreCase("TEXTAREA")) {

                    History.back();
                }
            }
        }
    }

    public void register() {
        handlerRegistration = Event.addNativePreviewHandler(this);
    }

    public void deregister() {
        handlerRegistration.removeHandler();
    }
}