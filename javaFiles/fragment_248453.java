import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
    public static final String[] LABELS = { "Job Name:", "Source Folder:", "Destination:",
            "File Regex:" };
    private static final int TF_COLS = 30;
    private static final Font LABEL_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 12);
    private static final Font ERROR_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 8);
    private static final String ERROR_MESSAGE = "Cannot Be Empty";
    private static final Color BACKGROUND = new Color(49, 49, 47);
    private static final String TITLE = "File Transfer Job Editor";
    private static final Color TITLE_COLOR = new Color(243, 112, 33);
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 28);
    private static final Color ERROR_BG_COLOR = new Color(255, 220, 220);
    private Map<String, JTextField> labelFieldMap = new HashMap<>();
    private Map<String, JLabel> errorLabelMap = new HashMap<>();

    public MyPanel() {
        JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
        titleLabel.setForeground(TITLE_COLOR);
        titleLabel.setFont(TITLE_FONT);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel labelFieldPanel = new JPanel(new GridBagLayout());
        labelFieldPanel.setOpaque(false);
        int bGap = 3;
        labelFieldPanel.setBorder(BorderFactory.createEmptyBorder(bGap, bGap, bGap, bGap));

        for (int i = 0; i < LABELS.length; i++) {
            String text = LABELS[i];
            JLabel label = new JLabel(text);
            JTextField textField = new JTextField(TF_COLS);
            JLabel errorLabel = new JLabel("    ");
            Border innerBorder = textField.getBorder();
            Border outerBorder = BorderFactory.createLineBorder(BACKGROUND);
            CompoundBorder myBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
            textField.setBorder(myBorder);

            label.setFont(LABEL_FONT);
            label.setForeground(Color.WHITE);
            errorLabel.setFont(ERROR_FONT);
            errorLabel.setForeground(Color.RED);

            labelFieldMap.put(text, textField);
            errorLabelMap.put(text, errorLabel);

            GridBagConstraints gbc = createLabelConstraint(i);
            labelFieldPanel.add(label, gbc);

            gbc = createTextFieldConstraints(i);
            labelFieldPanel.add(textField, gbc);

            gbc = createErrorLabelConstraints(i);
            labelFieldPanel.add(errorLabel, gbc);

            // add blank JLabel at the 0 position
            gbc.gridx = 0;
            labelFieldPanel.add(new JLabel(), gbc);
        }

        JButton acceptButton = new JButton("Accept");
        acceptButton.setMnemonic(KeyEvent.VK_A);
        acceptButton.addActionListener(e -> {
            boolean okToTransfer = true;
            for (int i = 0; i < LABELS.length; i++) {
                String text = LABELS[i];
                JTextField textField = labelFieldMap.get(text);
                JLabel errorLabel = errorLabelMap.get(text);

                CompoundBorder myBorder = (CompoundBorder) textField.getBorder();
                Border insideBorder = myBorder.getInsideBorder();

                if (i < LABELS.length - 1 && textField.getText().trim().isEmpty()) {
                    errorLabel.setText(ERROR_MESSAGE);
                    textField.setBackground(ERROR_BG_COLOR);
                    okToTransfer = false;
                    Border outsideBorder = BorderFactory.createLineBorder(Color.RED);
                    CompoundBorder newBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
                    textField.setBorder(newBorder);
                } else {
                    errorLabel.setText(" ");
                    textField.setBackground(Color.WHITE);
                    Border outsideBorder = BorderFactory.createLineBorder(BACKGROUND);
                    CompoundBorder newBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
                    textField.setBorder(newBorder);
                }
                System.out.println(text + " " + textField.getText());
            }
            System.out.println();
            if (okToTransfer) {
                // TODO: transfer code here
                // Window win = SwingUtilities.getWindowAncestor(MyPanel.this);
                // win.dispose();
            }
        });
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setMnemonic(KeyEvent.VK_C);
        cancelBtn.addActionListener(e -> {
            Window win = SwingUtilities.getWindowAncestor(MyPanel.this);
            win.dispose();
        });
        int btnPanelGap = 15;
        JPanel btnPanel = new JPanel(new GridLayout(1, 0, btnPanelGap, 0));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(4, btnPanelGap, 4, btnPanelGap));
        btnPanel.setOpaque(false);
        btnPanel.add(acceptButton);
        btnPanel.add(cancelBtn);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(BACKGROUND);
        add(titlePanel);
        add(labelFieldPanel);
        add(btnPanel);
    }

    private GridBagConstraints createErrorLabelConstraints(int i) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2 * i + 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        return gbc;
    }

    private GridBagConstraints createTextFieldConstraints(int i) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2 * i;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        return gbc;
    }

    private GridBagConstraints createLabelConstraint(int i) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2 * i;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        return gbc;
    }

    private static void createAndShowGui() {
        MyPanel mainPanel = new MyPanel();

        JDialog dialog = new JDialog((JFrame) null, "Job Editor", ModalityType.APPLICATION_MODAL);
        dialog.getContentPane().add(mainPanel);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}