import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Arc2D;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Foo {

    private int endCap = BasicStroke.CAP_SQUARE;
    private JPanel graphicsPanel;

    public void createAndShowGUI() {
        graphicsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(50, getEndCap(), BasicStroke.JOIN_BEVEL));

                g2.setPaint(Color.GREEN);
                g2.draw(new Arc2D.Double(100, 100, 300, 300, 0, 180, Arc2D.OPEN));
                g2.setPaint(Color.BLUE);
                g2.draw(new Arc2D.Double(100, 100, 300, 300, 180, 180, Arc2D.OPEN));
            }
        };
        graphicsPanel.setBackground(Color.WHITE);

        JRadioButton buttButton = new JRadioButton("CAP_BUTT");
        JRadioButton roundButton = new JRadioButton("CAP_ROUND");
        JRadioButton squareButton = new JRadioButton("CAP_SQUARE");

        addRadioButtonListener(buttButton, BasicStroke.CAP_BUTT);
        addRadioButtonListener(roundButton, BasicStroke.CAP_ROUND);
        addRadioButtonListener(squareButton, BasicStroke.CAP_SQUARE);

        squareButton.doClick();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(buttButton);
        buttonGroup.add(roundButton);
        buttonGroup.add(squareButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttButton);
        buttonPanel.add(roundButton);
        buttonPanel.add(squareButton);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(graphicsPanel);

        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private void addRadioButtonListener(JRadioButton button, int endCap) {
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setEndCap(endCap);
                graphicsPanel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Foo().createAndShowGUI());
    }

    public int getEndCap() {
        return endCap;
    }

    public void setEndCap(int endCap) {
        this.endCap = endCap;
    }

}