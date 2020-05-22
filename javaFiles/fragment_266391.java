//TestPerson.java 
import javax.swing.*;
import java.awt.*;



public class TestPerson extends JFrame{

    public TestPerson(){
        super("TestPerson");        


        JMenuBar pmb = new JMenuBar();
        this.setLayout(new BorderLayout());
        this.setJMenuBar(pmb);
        //this.setLocationRelativeTo(null);


        JMenu file = new JMenu("File");
        JMenu display = new JMenu("Display");
        JMenu edit = new JMenu("Edit");

        pmb.add(file);
        pmb.add(display);
        pmb.add(edit);

        file.add(new JMenuItem("Open"));
        file.add(new JMenuItem("Save"));

        edit.add(new JMenuItem("Add"));
        edit.add(new JMenuItem("Remove"));
        edit.add(new JMenuItem("Modithisy"));

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Something"));
        p1.add(new JTextField("Type here"));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Something New"));
        p2.add(new JTextField("Type here again"));

        this.add(p1);
        this.add(p2);

        this.setSize(600, 600);
        this.setVisible(true);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String [] args){
        new TestPerson();
    }
}