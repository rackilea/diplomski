import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener {

    JButton b1 = new JButton("Load from file");
    JButton b2 = new JButton("Save to file");
    JButton b3 = new JButton("Add hotel and resrvations");
    JButton b4 = new JButton("Search hotel by id");
    JButton b5 = new JButton("Search reservation by name");

    Main m0 ;

    public Window(Main main0) {

        super("Management");//Name
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        FlowLayout flow = new FlowLayout();
        setLayout(flow);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        pack();

        setVisible(true);

        m0 = main0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();
        if(source == b1) {
            m0.loadFile();
        }else if(source == b2) {
            m0.saveFile();
        }else if(source == b3) {
            m0.addHotel();
        }else if(source == b4) {
            m0.searchById();
        }else if(source == b5) {
            m0.searchByName();
        }
    }

    public static void main(String[] args) {
        new Window(new Main());
    }
}

class Main {

    public void loadFile() {
        System.out.println("loadFile pressed");
    }

    public void searchByName() {
        System.out.println("searchByName pressed");
    }

    public void searchById() {
        System.out.println("searchById() pressed");
    }

    public void addHotel() {
        System.out.println("addHotel pressed");
    }

    public void saveFile() {
        System.out.println("saveFile pressed");
    }
}