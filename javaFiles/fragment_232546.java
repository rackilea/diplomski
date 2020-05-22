import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class HsvChooserPanel2 extends JPanel {
    public static final String COLOR = "color";
    private static final int PREF_W = 180;
    private static final int PREF_H = PREF_W;
    private static final int PREF_W_CB = 20;
    private static final int GAP = 10;
    private MyColorPanel2 colorPanel = null;
    private MyColorBar2 colorBar = null;
    private InnerControl2 innerControl = null;

    public HsvChooserPanel2(ColorProperty colorProp) {
        colorPanel = new MyColorPanel2(PREF_W, PREF_H, colorProp);
        colorBar = new MyColorBar2(PREF_W_CB, PREF_H, colorProp);
        innerControl = new InnerControl2(this, colorPanel, colorBar);
        colorPanel.setColorPropertyValue(Color.RED); // !! magic value
        setLayout(new BorderLayout(GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        add(colorPanel, BorderLayout.CENTER);
        add(colorBar, BorderLayout.LINE_END);

        // propagate COLOR changes in the inner controller
        // to this component's property change support
        innerControl.addPropertyChangeListener(COLOR, pce -> {
            firePropertyChange(COLOR, pce.getOldValue(), pce.getNewValue());
        });
    }


}