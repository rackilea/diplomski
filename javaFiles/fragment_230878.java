import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    private JTextField txtSourceDirectory;
    private JTextField txtTargetDirectory;
    private JTextField txtDefectNumber;
    private JTextField txtSliceTokens;
    private JButton btnStart;

    public Main() {
        txtSourceDirectory = new JTextField(40); //change this to the amount of characters you need
        txtTargetDirectory = new JTextField(40);
        txtDefectNumber = new JTextField(40);
        txtSliceTokens = new JTextField(40);
        btnStart = new JButton("Start");
        add(txtSourceDirectory);
        add(txtTargetDirectory);
        add(txtDefectNumber);
        add(txtSliceTokens);
        add(btnStart);
        btnStart.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        //do stuff
    }

    static void startProcess(String[] ARGS) {
        //do stuff
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            Main frame = new Main();
        } else {
            startProcess(args);
        }
    }
}