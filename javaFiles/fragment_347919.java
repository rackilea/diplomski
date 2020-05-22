import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class Foo02 extends JPanel {
    private DrawPanel mainPanel;
    private Dimension dim = new Dimension(200, 200);

    public Foo02() {
        initComponents();
    }

    public void initComponents() {
        mainPanel = new DrawPanel(dim);
        // !! this.getContentPane().setLayout(new GridBagLayout());
        setLayout(new GridBagLayout()); // !!
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane jsp = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setLayout(new ScrollPaneLayout());
        jsp.setViewportView(mainPanel);
        jsp.getVerticalScrollBar().setUnitIncrement(20);
        jsp.setBorder(BorderFactory.createEmptyBorder());
        jsp.setPreferredSize(new Dimension(dim.width, dim.height));
        jsp.setMinimumSize(new Dimension(dim.width, dim.height));
        jsp.setMaximumSize(new Dimension(dim.width, dim.height));
        add(jsp, gbc);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        Foo02 mainPanel = new Foo02();
        JFrame frame = new JFrame("Foo02");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

@SuppressWarnings("serial")
class DrawPanel extends JPanel {
    private Dimension dim;
    private Integer numberPanels = 7;
    private Double startPointX;
    private Double startPointY;
    private Double heightRow;
    private Double heightPanel;

    public DrawPanel(Dimension d) {
        this.dim = d;
        // this.setBackground(Color.BLACK);
        calculateStartPoint();
    }

    public void calculateStartPoint() {
        startPointX = (dim.getWidth() / 10) * 1;
        startPointY = (dim.getHeight() / 10) * 1;
        heightRow = (dim.getHeight() * 0.8) / numberPanels;
        heightPanel = heightRow - 10;
        double colums = 366 / numberPanels;
        this.setPreferredSize(new Dimension((int) (heightRow * ((int) colums + 1)), dim.height));
        this.setMinimumSize(new Dimension((int) (heightRow * ((int) colums + 1)), dim.height));
    }

    @Override
    protected void paintComponent(Graphics g) { // should be protected
        super.paintComponent(g);
        // need to re-initialize variables within this
        startPointX = (dim.getWidth() / 10) * 1;
        startPointY = (dim.getHeight() / 10) * 1;

        g.setColor(Color.GRAY);
        for (int i = 1; i <= 366; i++) {
            // Si c'est le dernier d'une colonne
            if (i % numberPanels == 0 && i != 0) {
                g.fillRect(startPointX.intValue(), startPointY.intValue(), heightPanel.intValue(),
                        heightPanel.intValue());
                startPointX = startPointX + heightRow;
                startPointY = startPointY - ((numberPanels - 1) * heightRow);
                // Si c'est encore dans la meme colonne
            } else {
                g.fillRect(startPointX.intValue(), startPointY.intValue(), heightPanel.intValue(),
                        heightPanel.intValue());
                startPointY = startPointY + heightRow;
            }
        }
    }
}