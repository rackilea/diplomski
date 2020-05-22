import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Tes extends JFrame {

    String input;
    JTextField jtxt; 
    JButton mbutt; 


    public Tes(){

 //--ALWAYS USE A JPANEL OVER JFRAME, I DID THIS TO KEEP IT SIMPLE FOR U--//

        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setComponent();
        this.setHandler();
    }

    public void setComponent(){

        jtxt =  new JTextField("Hello");

        mbutt = new JButton("Button"); 

        this.add(BorderLayout.SOUTH,mbutt);

        this.add(BorderLayout.NORTH,jtxt);

    }

    public void setHandler(){

        mbutt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                input = jtxt.getText().toString();

                System.out.println("Input Value: "+input);

          **//--See your Console Output everytime u press the button--//**

            }
        });

    }
    public static void main(String[] args){


         EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {

                Tes t = new Tes();
                t.setVisible(true);

            }



         });
    }

}