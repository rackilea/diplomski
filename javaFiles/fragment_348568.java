import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class TomGuiPanel extends JPanel {
    // rows and cols for jtextarea
    private static final int CURRENT_AREA_ROWS = 20;
    private static final int CURRENT_AREA_COLS = 40;

    // columns for command jtextfied
    private static final int COMMANDS_FIELD_COLS = 50;

    // size of GUI component gaps
    private static final int EB_GAP = 3;
    private static final int NUMBER_OF_OPTIONS = 5;

    // number if ImageIcons displayed within the user image char JList
    private static final int CHAR_IMG_VISIBLE_ROWS = 5;

    // a guess of the width of the largest image icon in the JList
    // You'd use a different number
    private static final int USER_IMG_CHAR_IMG_WIDTH = 70;

    private JTextArea currentTextArea = new JTextArea(CURRENT_AREA_ROWS, CURRENT_AREA_COLS);
    private JTextField commandsField = new JTextField(COMMANDS_FIELD_COLS);
    private EnterAction enterAction = new EnterAction("Enter");
    private DefaultListModel<Icon> charImgListModel = new DefaultListModel<>();
    private JList<Icon> charImgList = new JList<>(charImgListModel);

    public TomGuiPanel() {
        JPanel topBtnPanel = new JPanel(new GridLayout(1, 0, EB_GAP, EB_GAP));
        String[] btnTexts = { "Inventory", "Options", "Save", "Load" };
        for (String txt : btnTexts) {
            topBtnPanel.add(new JButton(txt));
        }

        JPanel characteristicsPanel = new JPanel(new GridBagLayout());
        addCharacteristics(characteristicsPanel, "HP", 20, 0);
        addCharacteristics(characteristicsPanel, "Attack", 12, 1);
        addCharacteristics(characteristicsPanel, "Defence", 8, 2);
        addCharacteristics(characteristicsPanel, "Agility", 9, 3);
        addCharacteristics(characteristicsPanel, "Luck", 2, 4);

        JScrollPane imgListPane = new JScrollPane(charImgList);
        imgListPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        charImgList.setVisibleRowCount(CHAR_IMG_VISIBLE_ROWS);
        charImgList.setPrototypeCellValue(createProtoType());

        JPanel rightPanel = new JPanel(new BorderLayout(EB_GAP, EB_GAP));
        rightPanel.add(topBtnPanel, BorderLayout.PAGE_START);
        rightPanel.add(imgListPane, BorderLayout.CENTER);
        rightPanel.add(characteristicsPanel, BorderLayout.LINE_END);

        JPanel optionsPanel = new JPanel(new GridLayout(1, 0));
        for (int i = 0; i < NUMBER_OF_OPTIONS; i++) {
            String text = "Option " + (i + 1);
            optionsPanel.add(new JCheckBox(text));
        }

        currentTextArea.setWrapStyleWord(true);
        currentTextArea.setLineWrap(true);
        currentTextArea.setFocusable(false);
        JScrollPane taScrollPane = new JScrollPane(currentTextArea);
        taScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(taScrollPane, BorderLayout.CENTER);
        centerPanel.add(rightPanel, BorderLayout.LINE_END);
        centerPanel.add(optionsPanel, BorderLayout.PAGE_END);

        JPanel commandsPanel = new JPanel();
        commandsPanel.setLayout(new BoxLayout(commandsPanel, BoxLayout.LINE_AXIS));
        commandsPanel.add(commandsField);
        commandsPanel.add(Box.createHorizontalStrut(EB_GAP));
        commandsPanel.add(new JButton(enterAction));
        commandsPanel.add(Box.createHorizontalStrut(EB_GAP));
        commandsPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));
        commandsField.setAction(enterAction); // use same action for button and
                                              // text field

        setBorder(BorderFactory.createEmptyBorder(EB_GAP, EB_GAP, EB_GAP, EB_GAP));
        setLayout(new BorderLayout(EB_GAP, EB_GAP));
        add(centerPanel, BorderLayout.CENTER);
        add(commandsPanel, BorderLayout.PAGE_END);
    }

    private void addCharacteristics(JPanel cPanel, String text, int value, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        cPanel.add(new JLabel(text), gbc);

        gbc.insets.left = 20;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 1;
        cPanel.add(new JLabel(String.valueOf(value)), gbc);

    }

    private Icon createProtoType() {
        int w = USER_IMG_CHAR_IMG_WIDTH;
        int h = w;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Icon icon = new ImageIcon(img);
        return icon;
    }

    private class EnterAction extends AbstractAction {
        public EnterAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = commandsField.getText();
            currentTextArea.append(text + "\n");
            commandsField.selectAll();
        }
    }

    private class ExitAction extends AbstractAction {
        public ExitAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Component source = (Component) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(source);
            win.dispose();
        }
    }

    private static void createAndShowGUI() {
        TomGuiPanel mainPanel = new TomGuiPanel();

        JFrame frame = new JFrame("Tom's GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}