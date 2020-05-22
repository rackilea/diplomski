import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;

public class BasicZoomUI extends ZoomUI {

    private ZoomComponent zoomComponent;
    private MouseAdapter mouseHandler;
    private ChangeListener changeHandler;

    private Action zoomIn;
    private Action zoomOut;
    private PropertyChangeListener propertyChangeHandler;

    protected ChangeListener getChangeHandler() {
        if (changeHandler == null) {
            changeHandler = new ChangeHandler();
        }
        return changeHandler;
    }

    protected void installMouseListener() {
        mouseHandler = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                zoomComponent.requestFocusInWindow();
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int amount = e.getWheelRotation();
                ZoomModel model = zoomComponent.getModel();
                if (model != null) {

                    int value = model.getValue();
                    model.setValue(value + amount);

                }
            }

        };
        zoomComponent.addMouseListener(mouseHandler);
        zoomComponent.addMouseWheelListener(mouseHandler);

    }

    protected void installModelPropertyChangeListener() {

        propertyChangeHandler = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                ZoomModel old = (ZoomModel) evt.getOldValue();
                if (old != null) {
                    old.removeChangeListener(getChangeHandler());
                }
                ZoomModel newValue = (ZoomModel) evt.getNewValue();
                if (newValue != null) {
                    newValue.addChangeListener(getChangeHandler());
                }
            }
        };

        zoomComponent.addPropertyChangeListener("model", propertyChangeHandler);

    }

    protected void installKeyBindings() {

        zoomIn = new ZoomInAction();
        zoomOut = new ZoomOutAction();

        InputMap inputMap = zoomComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "zoomIn");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "zoomOut");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "zoomIn");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "zoomOut");

        ActionMap actionMap = zoomComponent.getActionMap();
        actionMap.put("zoomIn", zoomIn);
        actionMap.put("zoomOut", zoomOut);
    }

    protected void installModelChangeListener() {

        ZoomModel model = getModel();
        if (model != null) {
            model.addChangeListener(getChangeHandler());
        }

    }

    @Override
    public void installUI(JComponent c) {

        zoomComponent = (ZoomComponent) c;

        installMouseListener();
        installModelPropertyChangeListener();
        installKeyBindings();
        installModelChangeListener();

    }

    protected void uninstallModelChangeListener() {

        getModel().removeChangeListener(getChangeHandler());

    }

    protected void uninstallKeyBindings() {

        InputMap inputMap = zoomComponent.getInputMap(JComponent.WHEN_FOCUSED);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "donothing");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "donothing");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "donothing");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "donothing");

        AbstractAction blank = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };

        ActionMap actionMap = zoomComponent.getActionMap();
        actionMap.put("zoomIn", blank);
        actionMap.put("zoomOut", blank);

    }

    protected void uninstallModelPropertyChangeListener() {

        zoomComponent.removePropertyChangeListener(propertyChangeHandler);
        propertyChangeHandler = null;

    }

    protected void uninstallMouseListener() {

        zoomComponent.removeMouseWheelListener(mouseHandler);
        mouseHandler = null;

    }

    @Override
    public void uninstallUI(JComponent c) {

        uninstallModelChangeListener();
        uninstallModelPropertyChangeListener();
        uninstallKeyBindings();
        uninstallMouseListener();

        mouseHandler = null;
        zoomComponent = null;

    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        paintImage(g);
    }

    protected void paintImage(Graphics g) {
        if (zoomComponent != null) {
            ZoomModel model = zoomComponent.getModel();
            Image image = model.getImage();
            Dimension size = model.getScaledSize();
            int x = (zoomComponent.getWidth() - size.width) / 2;
            int y = (zoomComponent.getHeight() - size.height) / 2;
            g.drawImage(image, x, y, size.width, size.height, zoomComponent);
        }
    }

    public static ComponentUI createUI(JComponent c) {
        return new BasicZoomUI();
    }

    protected ZoomModel getModel() {

        return zoomComponent == null ? null : zoomComponent.getModel();

    }

    protected class ChangeHandler implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            zoomComponent.revalidate();
            zoomComponent.repaint();
        }

    }

    protected class ZoomAction extends AbstractAction {

        private int delta;

        public ZoomAction(int delta) {
            this.delta = delta;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ZoomModel model = getModel();
            if (model != null) {
                model.setValue(model.getValue() + delta);
            }
        }

    }

    protected class ZoomOutAction extends ZoomAction {

        public ZoomOutAction() {
            super(-5);
        }

    }

    protected class ZoomInAction extends ZoomAction {

        public ZoomInAction() {
            super(5);
        }

    }

}