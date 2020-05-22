import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.UIManager;

public class ZoomComponent extends JComponent {

    private static final String uiClassID = "ZoomComponentUI";
    private ZoomModel model;

    public ZoomComponent() {
        setBackground(Color.black);
        setFocusable(true);
        updateUI();
    }

    public void setModel(ZoomModel newModel) {
        if (model != newModel) {
            ZoomModel old = model;
            this.model = newModel;
            firePropertyChange("model", old, newModel);
        }
    }

    public ZoomModel getModel() {
        return model;
    }

    @Override
    public Dimension getPreferredSize() {
        ZoomModel model = getModel();
        Dimension size = new Dimension(100, 100);
        if (model != null) {
            size = model.getScaledSize();
        }
        return size;
    }

    public void setUI(BasicZoomUI ui) {
        super.setUI(ui);
    }

    @Override
    public void updateUI() {
        if (UIManager.get(getUIClassID()) != null) {
            ZoomUI ui = (ZoomUI) UIManager.getUI(this);
            setUI(ui);
        } else {
            setUI(new BasicZoomUI());
        }
    }

    public BasicZoomUI getUI() {
        return (BasicZoomUI) ui;
    }

    @Override
    public String getUIClassID() {
        return uiClassID;
    }
}