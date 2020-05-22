import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Test extends JFrame {

    private JComboBox box;

    public static void main(String[] args) {
        new Test();
    }

    public Test()
    {
        super();
        setSize(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        box = new JComboBox();
        box.setEditable(true);
        getContentPane().add(box);

        box.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                if (e.getActionCommand().equals("comboBoxEdited")) { 
                    System.out.println("Adding new player!");
                    box.insertItemAt(box.getSelectedItem(), 0);
                } 
            } 
        });

        setVisible(true);
    }
}