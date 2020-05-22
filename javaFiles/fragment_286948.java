package ofb_reader_package;

import javax.swing.*;

import java.awt.*;



public class OFB_Reader_GUI_and_Main  {





    public static void addComponentsToPane(Container pane) {

        JLabel label_url_eingabe;
        JTextField url_eingabe;

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();        

        label_url_eingabe = new JLabel("URL:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(label_url_eingabe, c);

        url_eingabe = url_eingabe = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(url_eingabe, c);

    }

     private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        }   






public static void main(String[] args){

    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });
}
}