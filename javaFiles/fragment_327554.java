import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import java.util.Calendar;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import java.awt.Color;
    import java.awt.Toolkit;


    class clockExample1 extends JFrame {


    private JTextField _textfield1; 

    public clockExample1() {
        System.out.println("Flow Here"+"2");
        _textfield1 = new JTextField(5);
        _textfield1.setEditable(false);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(_textfield1); 
        JButton button1 = new JButton("click here");


        this.setContentPane(panel1);
        this.setTitle("Text Clock 1");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        panel1.add(button1);



        System.out.println("Flow Here"+"3");
        ClockListener cl = new ClockListener();
        Timer t = new Timer(1000, cl);
        t.start();


            }



    class ClockListener implements ActionListener {

    int count = 0, alternativecounter=0;

    public void actionPerformed(ActionEvent e) {
        System.out.println("Flow Here"+"4");
        int fakeSecond = (count++ % 4) + 1; 


        if (fakeSecond == 1) {  
            alternativecounter+=1;
            System.out.println("alternativecounter"+alternativecounter);
            if(alternativecounter==2)
            {

                alternativecounter=0;
                System.out.println("alternativecounter"+alternativecounter);
                JOptionPane.showMessageDialog(null,"Warm Welcome to you, My dear friend");
            }

    }
        System.out.println("Flow Here"+"5");
        Calendar now = Calendar.getInstance();
        int h = now.get(Calendar.HOUR_OF_DAY);
        int m = now.get(Calendar.MINUTE);
        int s = now.get(Calendar.SECOND);
        _textfield1.setText("" + fakeSecond + "");


    }


    }




    public static void main(String[] args) {
        System.out.println("Flow Here"+"1");
        JFrame clock = new clockExample1();
        clock.setVisible(true);
    }

    }