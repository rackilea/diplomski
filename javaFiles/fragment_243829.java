import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;

public void onModuleLoad() {
    final TextArea textArea=new TextArea();
    textArea.setStyleName("textboxStyle");
    textArea.getElement().getStyle().setOverflow(Overflow.AUTO);
    textArea.getElement().setAttribute("wrap","off");

    textArea.setVisibleLines(1);

    textArea.addChangeHandler(new ChangeHandler() {

        @Override
        public void onChange(ChangeEvent event) {
            System.out.println("Value changed");
        }
    });

    textArea.addKeyPressHandler(new KeyPressHandler() {
        @Override
        public void onKeyPress(KeyPressEvent event) {
            int lines = 0;
            final String s = textArea.getText();
            for (int i = 0; i != -1; i = s.indexOf("\n", i + 1)) {
                lines++;
            }

            if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) { // User hit "Enter"
                // key
                lines++;
            }
            textArea.setVisibleLines(lines);
        }
    });
    RootPanel.get().add(textArea);
}