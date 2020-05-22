import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SPanel extends JPanel {

    public SPanel() {
        final TextAPanel textPanel = new TextAPanel();
        this.add(textPanel);

        final JLabel outputLabel = new JLabel();
        JButton click = new JButton("Click");
        click.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String word = textPanel.inputBox.getText();

                System.out.println("Test: " + word);
                System.out.println(word.split("\\s+").length);
            }

        });

        this.add(click);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new SPanel());
        f.setVisible(true);
    }

}

@SuppressWarnings("serial")
class TextAPanel extends JPanel {
    public JTextArea inputBox = new JTextArea(20, 10);
    public JScrollPane scrollPane = new JScrollPane(inputBox);

    TextAPanel() {

        JLabel title = new JLabel("Please type in the box below:");

        inputBox.setLineWrap(true);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.gridx = 0;
        gc.gridy = 0;

        add(title, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(scrollPane, gc);

    }

}