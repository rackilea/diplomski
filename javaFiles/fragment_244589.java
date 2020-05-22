import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class AddRadioButtons extends JPanel {
    private static final int PREF_W = 300;
    private static final int PREF_H = 400;

    // List that holds all added JRadioButtons
    private List<JRadioButton> radioButtonList = new ArrayList<>();

    // jpanel to hold radiobuttons in a verticle grid
    private JPanel buttonPanel = new JPanel(new GridLayout(0, 1)); 
    private JTextField radioBtnNameField = new JTextField(10);

    public AddRadioButtons() {
        // jpanel to add to jscrollpane
        // nesting JPanels so that JRadioButtons don't spread out inside the scrollpane.
        JPanel innerViewPanel = new JPanel(new BorderLayout());
        innerViewPanel.add(buttonPanel, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(innerViewPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // holds textfield and button for adding new radiobuttons
        JPanel topPanel = new JPanel();
        topPanel.add(radioBtnNameField);
        Action addRBtnAction = new AddRadioBtnAction("Add Radio Button");
        topPanel.add(new JButton(addRBtnAction));
        radioBtnNameField.setAction(addRBtnAction);

        // holds button to display selected radiobuttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton(new PrintAllSelectedBtnAction("Print All Selected Buttons")));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    // I prefer to use AbstractAction in place of ActionListeners since
    // they have a little more flexibility and power.
    private class AddRadioBtnAction extends AbstractAction {
        public AddRadioBtnAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String text = radioBtnNameField.getText();
            JRadioButton rbtn = new JRadioButton(text);
            radioButtonList.add(rbtn);
            buttonPanel.add(rbtn);
            buttonPanel.revalidate();
            buttonPanel.repaint();

            radioBtnNameField.selectAll();
        }
    }

    private class PrintAllSelectedBtnAction extends AbstractAction {
        public PrintAllSelectedBtnAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (JRadioButton radioBtn : radioButtonList) {
                if (radioBtn.isSelected()) {
                    System.out.println(radioBtn.getActionCommand() + " is selected");
                }
            }
            System.out.println();
        }
    }

    private static void createAndShowGui() {
        AddRadioButtons mainPanel = new AddRadioButtons();

        JFrame frame = new JFrame("Add Radio Buttons");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // run the Swing code in a thread-safe manner
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}