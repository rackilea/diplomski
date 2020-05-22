import java.awt.*;
import javax.swing.*;

// TODO don't extend JPanel, just create an instance
class TestGui extends JPanel {

    JTextField arrivalDateTF;
    JTextField departureDateTF;
    JTextField roomCategoryTF;
    JTextField roomQtyTF;
    JButton submitB;

    TestGui() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        arrivalDateTF = new JTextField(6);
        departureDateTF = new JTextField(6);
        roomCategoryTF = new JTextField(8);
        roomQtyTF = new JTextField(2);

        JTextField[] textFields = { arrivalDateTF, departureDateTF, roomCategoryTF, roomQtyTF };
        JLabel[] textLabels = { new JLabel("1 : "), new JLabel("2 : "),
            new JLabel("3 : "), new JLabel("4 : ")
        };

        JPanel displayPan = new JPanel();
        GridBagLayout gridBagLay = new GridBagLayout();
        GridBagConstraints gridBagC = new GridBagConstraints();

        displayPan.setLayout(gridBagLay);
//      SwingUtilities.addTextElementsAsRows(textLabels, textFields, gridBagLay, displayPan);
        for (int ii=0; ii<textFields.length; ii++) {
            displayPan.add( textLabels[ii] );
            displayPan.add( textFields[ii] );
        }

        gridBagC.gridwidth = GridBagConstraints.REMAINDER;
        gridBagC.anchor = GridBagConstraints.EAST;
        gridBagC.weightx = 1.0;

        displayPan.add(new JLabel(" "), gridBagC);

        submitB = new JButton("Soumettre");
        displayPan.add(submitB, gridBagC);

//      SwingUtilities.addStdBorder(displayPan, "Reservation");
        add(displayPan, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame1 = new JFrame("Hotel Reservation App");
                frame1.getContentPane().add(new TestGui(), BorderLayout.CENTER);
                frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                frame1.pack();
                frame1.setVisible(true);
            }
        });
    }
}