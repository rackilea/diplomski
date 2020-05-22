import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EventTest extends JFrame implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventTest();
            }
        });
    }

    private JComboBox<String> colourSelector;
    private String colours[] = {"Red", "Yellow", "Green", "Blue", "Orange"};
    private JPanel panel;

    EventTest() {

        super("My First Frame");

        //Create a JPanel and content frame
        Container contentPane = getContentPane();
        panel = new JPanel();

        //Create a JCombo Box
        colourSelector = new JComboBox(colours);
        colourSelector.addActionListener(this);  //Add listener to the box
        panel.add(colourSelector);   //Add combobox to the panel

        //Create a JButton
        JButton changeColour = new JButton("Change Colour"); //Create a new JButton.
        changeColour.addActionListener(this); //Add listener to the button.
        panel.add(changeColour); //Add button to the panel.

        //Add the content to the pane
        contentPane.add(panel);

        //Set window parameters
        setTitle("Lab4");
        setSize(800, 600);
        setVisible(true);

    }//End Constructor

    //Action Listener - An action listener that changes the colour of our JPanel to the
    //colour selected by the user.
    public void actionPerformed(ActionEvent e) {

//        private String colours[] = {"Red", "Yellow", "Green", "Blue", "Orange"};

        String selectedItem = (String)colourSelector.getSelectedItem();
        System.out.println(selectedItem);
        switch (selectedItem) {
            case "Red": 
                panel.setBackground(Color.RED);
                break;
            case "Yellow": 
                panel.setBackground(Color.YELLOW);
                break;
            case "Green": 
                panel.setBackground(Color.GREEN);
                break;
            case "Blue": 
                panel.setBackground(Color.BLUE);
                break;
            case "Orange": 
                panel.setBackground(Color.ORANGE);
                break;
        }
    }

}//End Class