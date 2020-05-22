import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class BunchARadios extends JPanel {
    private static final int GAP = 5;
    public static final String SELECTION = "selection";
    private ButtonGroup buttonGroup = new ButtonGroup();

    public BunchARadios(String title, List<String> radioLabels) {
        Border innerBorder = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP);
        Border outerBorder = BorderFactory.createTitledBorder(title);
        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        setBorder(border);
        setLayout(new GridLayout(0, 1, GAP, GAP));

        RButtonListener rButtonListener = new RButtonListener();
        for (String radioLabel : radioLabels) {
            JRadioButton radioButton = new JRadioButton(radioLabel);
            radioButton.setActionCommand(radioLabel);
            add(radioButton);
            buttonGroup.add(radioButton);
            radioButton.addActionListener(rButtonListener);
        }        
    }

    public String getSelection() {
        ButtonModel model = buttonGroup.getSelection();
        if (model == null) {
            return null; // throw exception?
        } else {
            return model.getActionCommand();
        }
    }

    private class RButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firePropertyChange(SELECTION, null, e.getActionCommand());
        }
    }
}