import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class ExcellentGUI {

    private JTextField[] txtAllAverages;
    int testCount = 2;

    public void createAverageGUI()
    {
        txtAllAverages = new JTextField[testCount];

        JPanel inputControls = new JPanel(new BorderLayout(5,5));

        JPanel inputControlsLabels = new JPanel(new GridLayout(0,1,3,3));
        JPanel inputControlsFields = new JPanel(new GridLayout(0,1,3,3));
        inputControls.add(inputControlsLabels, BorderLayout.WEST);
        inputControls.add(inputControlsFields, BorderLayout.CENTER);
        for (int i = 0; i < testCount; i++)
        {
            inputControlsLabels.add(new JLabel("Test score: "));
            JTextField field = new JTextField(10);
            inputControlsFields.add(field);
            txtAllAverages[i] = field;
        }

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));

        controls.add(new JButton("Reset"));
        controls.add(new JButton("Submit"));

        JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder("Averages"));
        gui.add(inputControls, BorderLayout.CENTER);
        gui.add(controls, BorderLayout.SOUTH);

        JFrame averageFrame = new JFrame("Get All Test Scores");
        averageFrame.setContentPane(gui);
        // let the components assume the natural size
        // averageFrame.setSize(400, 600);
        averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        averageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExcellentGUI().createAverageGUI();
            }
        });
    }
}