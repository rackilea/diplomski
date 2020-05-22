import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class RadioDemo implements ActionListener {

    String buttonName;
    JPanel radioPanel = new JPanel();
    ButtonGroup group = new ButtonGroup();
    int result;
    JRadioButton birdButton[];
    Vector<String> listName;
    private JRadioButton selectedButton;

    public RadioDemo(Vector<String> listName) {
        birdButton = new JRadioButton[listName.size()];
        this.listName = listName;
        int i = 0;
        for (String buttonName : listName) {
            birdButton[i] = new JRadioButton(buttonName);
            if (i == 0) {
                birdButton[i].setSelected(true);
                selectedButton = birdButton[i];
            }
            birdButton[i].setActionCommand(buttonName);
            group.add(birdButton[i]);
            birdButton[i].addActionListener(this);
            radioPanel.add(birdButton[i]);
            i++;
        }

        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        // birdButton.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        result = JOptionPane.showConfirmDialog(null, radioPanel, "Please choose", JOptionPane.OK_CANCEL_OPTION);
        show();
    }

    /** Listens to the radio buttons. */
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton rb = (JRadioButton) e.getSource();
        System.err.println(rb.getText() + " is selected");
        selectedButton = rb;
    }

    public void show() {
        if (result == JOptionPane.OK_OPTION) {
            System.err.println(selectedButton.getText() + " is selected and approved");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Vector<String> buttonNames = new Vector<String>();
                buttonNames.add("Show");
                buttonNames.add("Something");
                buttonNames.add("Else");
                buttonNames.add("Beep");
                new RadioDemo(buttonNames);
            }
        });
    }
}