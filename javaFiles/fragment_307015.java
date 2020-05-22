import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestRadioButton {

    private void initUI() {
        JFrame frame = new JFrame(TestRadioButton.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        final JRadioButton button = new JRadioButton();
        final JLabel label = new JLabel("Double click me");
        final JTextField editionTF = new JTextField();
        editionTF.setOpaque(false);
        editionTF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                stopEdition(panel, label, editionTF);
            }

        });
        editionTF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stopEdition(panel, label, editionTF);
            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    startEdition(panel, label, editionTF);
                }
            }
        });
        editionTF.setBorder(BorderFactory.createEmptyBorder());
        editionTF.setFont(label.getFont());
        editionTF.setVisible(false);
        panel.add(button);
        panel.add(label);
        panel.add(editionTF);
        frame.add(panel, BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void stopEdition(final JPanel panel, final JLabel label, final JTextField editionTF) {
        label.setText(editionTF.getText());
        label.setVisible(true);
        editionTF.setVisible(false);
    }

    protected void startEdition(final JPanel panel, final JLabel label, final JTextField editionTF) {
        editionTF.setText(label.getText());
        label.setVisible(false);
        editionTF.setVisible(true);
    }

    public static void main(String[] args) {
        final TestRadioButton test = new TestRadioButton();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                test.initUI();
            }
        });
    }
}