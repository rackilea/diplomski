import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PassingValuesExample {

    private String qualification;
    private JTextField qualificationField;
    private JButton submitButton;

    private void displayGUI() {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        qualificationField = new JTextField(10);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                submitButtonActionPerformed(ae);
            }
        });
        contentPane.add(qualificationField);
        contentPane.add(submitButton);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void submitButtonActionPerformed(ActionEvent ae) {
        qualification = qualificationField.getText();
        new Foo(this).open();
    }

    public String getQualification() {
        return qualification;
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new PassingValuesExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class Foo {

    private PassingValuesExample pve;

    public Foo(PassingValuesExample pve) {
        this.pve = pve;
    }

    public void open() {
        String qual = pve.getQualification();
        switch(qual) {
            case "CA":
            case "MBA":
                System.out.println("Qualification: " + qual);
        }
    }
}