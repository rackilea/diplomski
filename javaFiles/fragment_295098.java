import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

//import Controller.HomeController;


//import music.PlaySound;

public class Home extends JFrame {

    private JLabel label, label1, label2;
    private JPanel panel;
    private JButton logo, logo1, logo2, logo3, logo4, logo5, selectie;
    private Container window = getContentPane();
    private HomeController Controller;

    public Home (){
        initGUI();
    }
    public void addHomeListener(ActionListener a){
        selectie.addActionListener(a);
    }
    public void initGUI(){

        setLayout(null);
        setTitle("");
        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();       
        label.setBounds(0, 0, 266, 800);
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        window.add(label);

        label1 = new JLabel();
        label1.setBounds(267, 0, 266, 800);
        label1.setBackground(Color.RED);
        label1.setOpaque(true);
        window.add(label1);

        label2 = new JLabel();
        label2.setBounds(533, 0, 266, 800);
        label2.setBackground(Color.WHITE);
        label2.setOpaque(true);
        window.add(label2);

        logo = new JButton(new ImageIcon("../Ajax/src/img/logotje.gif"));
        logo.setBorderPainted(false);
        logo.setBounds(40, 150, 188, 188);
        label1.add(logo);

        logo1 = new JButton(new ImageIcon("../Ajax/src/img/Ster.png"));
        logo1.setBorderPainted(false);
        logo1.setBounds(10, 50, 82, 82);
        label1.add(logo1);

        logo2 = new JButton(new ImageIcon("../Ajax/src/img/Ster.png"));
        logo2.setBorderPainted(false);
        logo2.setBounds(92, 20, 82, 82);
        label1.add(logo2);

        logo3 = new JButton(new ImageIcon("../Ajax/src/img/Ster.png"));
        logo3.setBorderPainted(false);
        logo3.setBounds(174, 50, 82, 82);
        label1.add(logo3);

        logo4 = new JButton(new ImageIcon("../Ajax/src/img/shirt.png"));
        logo4.setBorderPainted(false);
        logo4.setBounds(50, 50, 135, 182);
        label.add(logo4);

        logo5 = new JButton(new ImageIcon("../Ajax/src/img/uitshirt.png"));
        logo5.setBorderPainted(false);
        logo5.setBounds(65, 50, 138, 190);
        label2.add(logo5);

        selectie = new JButton("Selectie");
        selectie.setBounds(60, 500, 99, 25);
        selectie.setActionCommand("selectie");
        label.add(selectie);

        pack();

        /*
         * You are making a new object again,
         * when you already had declared it as 
         * an instance Variable. So I used the 
         * one declared as instance variable..
         * To this we will send the object of Home
         * class, means the object of this class..
         * And as we know that object of the 
         * class we are in is by default known 
         * as this, so passing this to HomeController class.
         */
        Controller = new HomeController(this);
        addHomeListener(Controller);

        setVisible(true);
    }

    public static void main(String... args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Home();
            }
        });
    }
}

class HomeController implements ActionListener {

    /*
     * Here we declared a Home class's variable,
     * that we will use to dispose that JFrame.
     */
    private Home home;

    public HomeController(Home home)
    {
        this.home = home;
    }

    public void actionPerformed (ActionEvent e){

            home.dispose();
            Selectie selectie = new Selectie();
            selectie.setVisible(true);
    }
}

class Selectie extends JFrame
{
    public Selectie()
    {
        initGUI();
    }

    public void initGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        setSize(300, 300);
    }
}