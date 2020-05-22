package stack;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DynamicButtons extends JFrame{

    JButton addMore = new JButton("AddMore");
    Container contentPane = null;

    public DynamicButtons(){

        contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        addMore.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton newButton = new JButton("ABCD");
                contentPane.invalidate();
                contentPane.add(newButton);
                pack();

            }
        });

        contentPane.add(addMore);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new DynamicButtons();
            }
        });
    }
}