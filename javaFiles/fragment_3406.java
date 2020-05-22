import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Library {

    private static JFrame frame;
    private JLabel addB;
    private JTextField aB;
    private JLabel issueB;
    private JTextField iB;
    private JLabel holdB;
    private JTextField hB;
    private JLabel renewB;
    private JTextField rB;
    private JButton logout;
    private ImageIcon logo;

    public Library() {
        frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setBackground(Color.RED);
    }

    //deals with the adding of textfield and label of adding book
    private void addBLabels() {
        addB = new JLabel("Add Book: ");
        GridBagConstraints padding = new GridBagConstraints();
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 4;
        padding.gridy = 0;
        frame.add(addB, padding);
        padding = new GridBagConstraints();
        aB = new JTextField(30);
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 5;
        padding.gridy = 0;
        frame.add(aB, padding);
    }

    //deals with issue book labels
    private void issueBLabels() {
        issueB = new JLabel("Issue Book: ");
        GridBagConstraints padding = new GridBagConstraints();
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 4;
        padding.gridy = 1;
        frame.add(issueB, padding);
        padding = new GridBagConstraints();
        iB = new JTextField(30);
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 5;
        padding.gridy = 1;
        frame.add(iB, padding);
    }

    //deals with holdbook labels
    private void holdBookLabels() {
        holdB = new JLabel("Hold Book: ");
        GridBagConstraints padding = new GridBagConstraints();
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 4;
        padding.gridy = 2;
        frame.add(holdB, padding);
        padding = new GridBagConstraints();
        hB = new JTextField(30);
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 5;
        padding.gridy = 2;
        frame.add(hB, padding);
    }

    //deals with the renewbook labels
    private void renewBookLabels() {
        renewB = new JLabel("Renew Book: ");
        GridBagConstraints padding = new GridBagConstraints();
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 4;
        padding.gridy = 3;
        frame.add(renewB, padding);
        padding = new GridBagConstraints();
        rB = new JTextField(30);
        padding.fill = GridBagConstraints.HORIZONTAL;
        padding.gridx = 5;
        padding.gridy = 3;
        frame.add(rB, padding);
    }

    //deals with adding the logout button
    private void logOutButton() {
        logout = new JButton("Logout");
        GridBagConstraints padding = new GridBagConstraints();
        padding.gridx = 5;
        padding.gridy = 5;
        padding.anchor = GridBagConstraints.LAST_LINE_END;
        padding.insets = new Insets(5, 0, 5, 5);
        frame.add(logout, padding);
    }

    //deals with adding the image
    private void addImage() throws IOException {
        JLabel picLabel = new JLabel(UIManager.getIcon("OptionPane.questionIcon"));
        GridBagConstraints padding = new GridBagConstraints();
        padding.fill = GridBagConstraints.VERTICAL;
        padding.gridx = 0;
        padding.gridy = 0;
        padding.weighty = 1.0d;
        padding.weightx = 1.0d;
        padding.gridheight = 6;
        padding.anchor = GridBagConstraints.LINE_START;
        padding.insets = new Insets(10, 10, 10, 10);
        frame.add(picLabel, padding);
        frame.pack();
    }

    public static void main(String args[]) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Library gui = new Library();
                gui.addBLabels();
                gui.issueBLabels();
                gui.holdBookLabels();
                gui.renewBookLabels();
                gui.logOutButton();
                try {
                    gui.addImage();
                } catch (IOException ex) {
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }
}