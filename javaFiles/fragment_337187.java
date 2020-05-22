import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagLayoutExample extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GridBagLayoutExample frame = new GridBagLayoutExample();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GridBagLayoutExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450, 450));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, 6.0, 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 1.0, 6.0, 1.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JPanel top = new JPanel();
        top.setBackground(Color.RED);
        GridBagConstraints gbc_top = new GridBagConstraints();
        gbc_top.gridwidth = 3;
        gbc_top.insets = new Insets(0, 0, 5, 5);
        gbc_top.fill = GridBagConstraints.BOTH;
        gbc_top.gridx = 0;
        gbc_top.gridy = 0;
        contentPane.add(top, gbc_top);

        JPanel left = new JPanel();
        left.setBackground(Color.BLUE);
        GridBagConstraints gbc_left = new GridBagConstraints();
        gbc_left.insets = new Insets(0, 0, 5, 5);
        gbc_left.fill = GridBagConstraints.BOTH;
        gbc_left.gridx = 0;
        gbc_left.gridy = 1;
        contentPane.add(left, gbc_left);

        JPanel middle = new JPanel();
        middle.setBackground(Color.BLACK);
        GridBagConstraints gbc_middle = new GridBagConstraints();
        gbc_middle.insets = new Insets(0, 0, 5, 5);
        gbc_middle.fill = GridBagConstraints.BOTH;
        gbc_middle.gridx = 1;
        gbc_middle.gridy = 1;
        contentPane.add(middle, gbc_middle);

        JPanel right = new JPanel();
        right.setBackground(Color.YELLOW);
        GridBagConstraints gbc_right = new GridBagConstraints();
        gbc_right.insets = new Insets(0, 0, 5, 0);
        gbc_right.fill = GridBagConstraints.BOTH;
        gbc_right.gridx = 2;
        gbc_right.gridy = 1;
        contentPane.add(right, gbc_right);

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.GREEN);
        GridBagConstraints gbc_bottom = new GridBagConstraints();
        gbc_bottom.insets = new Insets(0, 0, 0, 5);
        gbc_bottom.gridwidth = 3;
        gbc_bottom.fill = GridBagConstraints.BOTH;
        gbc_bottom.gridx = 0;
        gbc_bottom.gridy = 2;
        contentPane.add(bottom, gbc_bottom);

        pack();
    }

}