import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class TVGrid implements Runnable {

    protected static final Insets noInsets    = new Insets(0, 0, 0, 0);

    protected Dimension screenSize;

    protected JFrame frame;

    protected JPanel largePanel;
    protected JPanel mainPanel;

    protected JPanel[] smallPanels;

    protected Point[] smallPanelOrigins;

    public TVGrid() {
        this.smallPanels = new JPanel[7];
        setSmallPanelOrigins();
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();      
    }

    protected void setSmallPanelOrigins() {
        this.smallPanelOrigins = new Point[7];
        this.smallPanelOrigins[0] = new Point(3, 0);
        this.smallPanelOrigins[1] = new Point(3, 1);
        this.smallPanelOrigins[2] = new Point(3, 2);
        this.smallPanelOrigins[3] = new Point(0, 3);
        this.smallPanelOrigins[4] = new Point(1, 3);
        this.smallPanelOrigins[5] = new Point(2, 3);
        this.smallPanelOrigins[6] = new Point(3, 3);
    }

    @Override
    public void run() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        frame = new JFrame();
        frame.setTitle("TV Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        largePanel = new JPanel();
        largePanel.setPreferredSize(getLargePanelPreferredSize());
        largePanel.setBackground(Color.GREEN);
        largePanel.setBorder(border);

        addComponent(mainPanel, largePanel, 0, 0, 3, 3, noInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.BOTH);

        for (int i = 0; i < 7; i++) {
            smallPanels[i] = new JPanel();
            smallPanels[i].setPreferredSize(getSmallPanelPreferredSize());
            smallPanels[i].setBackground(Color.YELLOW);
            smallPanels[i].setBorder(border);

            int x = smallPanelOrigins[i].x;
            int y = smallPanelOrigins[i].y;

            addComponent(mainPanel, smallPanels[i], x, y, 1, 1, noInsets,
                    GridBagConstraints.LINE_START, GridBagConstraints.BOTH);
        }

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    protected Dimension getLargePanelPreferredSize() {
        Dimension d = new Dimension();
        d.width = ((screenSize.width - 30) * 3) / 4;
        d.height = ((screenSize.height - 90) * 3) / 4;
        return d;
    }

    protected Dimension getSmallPanelPreferredSize() {
        Dimension d = new Dimension();
        d.width = (screenSize.width - 30) / 4;
        d.height = (screenSize.height - 90) / 4;
        return d;
    }

    protected void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, 
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TVGrid());
    }


}