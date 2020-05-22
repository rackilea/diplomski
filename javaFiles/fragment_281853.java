import java.awt.event.*;

import java.awt.*;

import javax.swing.*;

public class Feedback extends JApplet implements ActionListener
{
    private JTextField login;

    private JTextField email;
    private JTextField comments;
    private final String SUBMIT="SUBMIT";
    private final String CLEAR="CLEAR";
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(CLEAR.equals(command))
            {login.setText(" ");
            email.setText(" ");
            comments.setText(" ");}
        else if(SUBMIT.equals(command))
           {
            login.setText(" ");
            email.setText(" ");
            comments.setText(" ");
           }
        }
     public void start()
    {
        Container contentPane = getContentPane();
        JScrollPane sPane = new JScrollPane();
        JPanel pContPanel = new JPanel();

        pContPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints(3, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10), 20, 20);

        JLabel title = new JLabel("FEEDBACK");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        pContPanel.add(title, gbc);

        JPanel panel1 = new JPanel();
        JLabel prompt = new JLabel("LOGIN");
        panel1.add(prompt, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pContPanel.add(panel1, gbc);

        login = new JTextField(15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        pContPanel.add(login, gbc);

        JPanel panel2=new JPanel();
        JLabel print = new JLabel("EMAIL");
        panel2.add(print);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        pContPanel.add(panel2, gbc);

        email = new JTextField(30);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pContPanel.add(email, gbc);

        JPanel panel3=new JPanel();
        JLabel ask = new JLabel("COMMENTS");
        panel3.add(ask);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pContPanel.add(panel3, gbc);

        comments = new JTextField(50);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pContPanel.add(comments, gbc);

        JButton bSUBMIT = new JButton(SUBMIT);
        bSUBMIT.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pContPanel.add(bSUBMIT, gbc);

        JButton bCLEAR = new JButton(CLEAR);
        bCLEAR.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        pContPanel.add(bCLEAR, gbc);


         sPane.setViewportView(pContPanel);
         contentPane.add(sPane, BorderLayout.CENTER);
        }
    }