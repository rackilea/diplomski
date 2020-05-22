import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Main{

    public void userInput(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Give hotel's name : ");
        String name = scan.nextLine();

        System.out.println(name);
    }

    public static void main(String[] args){    //added    String[] args
        Main m0 = new Main();
        Window w = new Window(m0);
    }
}

class Window extends JFrame implements ActionListener {

    JButton b1 = new JButton("Get input");
    Main m0 = new Main();

    public Window(Main main0) {
        super("Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(this);

        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(b1);

        pack();

        setVisible(true);

        m0 = main0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == b1) {
            m0.userInput();
        }
    }
}