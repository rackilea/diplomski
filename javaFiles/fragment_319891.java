import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example {

    public Example() {

        JPanel parentPanel = new JPanel(new GridBagLayout());
        parentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridheight = 2;
        parentPanel.add(createChildPanel(1), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        parentPanel.add(createChildPanel(2), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        parentPanel.add(createChildPanel(3), gbc);

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.getContentPane().add(parentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createChildPanel(int number) {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(150, 150);
            }
        };

        JPanel addPanel = new JPanel();
        addPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPanel.add(new JLabel("Label"));
                addPanel.revalidate();
                addPanel.repaint();
            }
        });

        JButton deleteButton = new JButton("-");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (addPanel.getComponentCount() > 0) {
                    addPanel.remove(addPanel.getComponent(addPanel.getComponentCount() - 1));
                    addPanel.revalidate();
                    addPanel.repaint();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        JLabel label = new JLabel(String.valueOf(number));
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(label, BorderLayout.NORTH);
        panel.add(addPanel);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

}