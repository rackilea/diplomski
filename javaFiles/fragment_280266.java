import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicTableHeaderUI;

public class SorterChooserTableHeaderUI extends BasicTableHeaderUI {

    public class MouseInputHandler extends BasicTableHeaderUI.MouseInputHandler {
        public void mouseClicked (MouseEvent ev) {
            if (ev.getModifiersEx() == 0)
                super.mouseClicked(ev);
        }
    }

    @Override
    protected MouseInputListener createMouseInputListener () {
        return new MouseInputHandler();
    }

}