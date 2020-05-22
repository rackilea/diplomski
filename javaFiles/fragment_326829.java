import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MockJComboBox {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JPanel popupContent = new JPanel(new GridLayout(0, 1));
                popupContent.setBackground(Color.GREEN);
                popupContent.add(new JLabel("Content of popupContent panel"));
                popupContent.add(new JLabel("Content of popupContent panel"));
                popupContent.add(new JLabel("Content of popupContent panel"));
                popupContent.add(new JLabel("Content of popupContent panel"));
                popupContent.add(new JLabel("Content of popupContent panel"));
                popupContent.add(new JComboBox(new Object[]{"Content of popupContent panel"}));
                final JButton popupCloseButton = new JButton("X");
                popupContent.add(popupCloseButton);

                final JScrollPane s = new JScrollPane(popupContent);
                s.setPreferredSize(new Dimension(popupContent.getPreferredSize().width + s.getVerticalScrollBar().getPreferredSize().width
                        + s.getBorder().getBorderInsets(s).left
                        + s.getBorder().getBorderInsets(s).right, 100));

                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(200, 200));
                final JButton popupOpenButton = new JButton();
                panel.add(popupOpenButton);
                final JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setContentPane(panel);
                final PopupFactory popupFactory = PopupFactory.getSharedInstance();
                popupOpenButton.setAction(new AbstractAction("Open") {
                    private Popup popup;
                    private boolean isShown = false;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isShown) {
                            popup.hide();
                        } else {
                            popup = popupFactory.getPopup(popupOpenButton, s,
                                    popupOpenButton.getLocationOnScreen().x, popupOpenButton.getLocationOnScreen().y + popupOpenButton.getHeight());
                            popupCloseButton.setAction(new AbstractAction(popupCloseButton.getText()) {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    isShown = false;
                                    popup.hide();
                                }
                            });
                            popup.show();
                        }
                        isShown = !isShown;
                    }
                });
                f.pack();
                f.setVisible(true);
            }
        });
    }
}