import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class UseDrawingSettings extends JPanel {
    private JTextArea textArea = new JTextArea(20, 40);
    private DrawingSettingWindow drawingSettings;

    public UseDrawingSettings() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JButton(new ShowDrawSettings()));
        setLayout(new BorderLayout());

        add(new JScrollPane(textArea));
        add(topPanel, BorderLayout.PAGE_START);
    }

    private class ShowDrawSettings extends AbstractAction {
        public ShowDrawSettings() {
            super("Get Drawing Settings");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (drawingSettings == null) {
                Window win = SwingUtilities.getWindowAncestor(UseDrawingSettings.this);
                drawingSettings = new DrawingSettingWindow(win);
            }
            drawingSettings.setVisible(true);

            // here you extract the data
            Object color = drawingSettings.getColor();
            boolean filled = drawingSettings.getFilled();
            textArea.append("Color: " + color + "\n");
            textArea.append("Filled: " + filled + "\n");                
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        UseDrawingSettings mainPanel = new UseDrawingSettings();
        JFrame frame = new JFrame("UseDrawingSettings");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}