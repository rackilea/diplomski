import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;

public class MyFrame17 extends JFrame {

    JButton panicButton;
    JButton dontPanic;
    JButton blameButton;
    JButton newsButton;
    JButton mediaButton;
    JButton saveButton;
    JButton dontSave;

    public MyFrame17() {
        super("Crazy App");
        setLayout(new GridLayout(2, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel row1 = new JPanel();
        panicButton = new JButton("Panic");
        dontPanic = new JButton("No Panic");
        blameButton = new JButton("Blame");
        newsButton = new JButton("News");
        FlowLayout flow1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        row1.setLayout(flow1);
        row1.add(panicButton);
        row1.add(dontPanic);
        row1.add(blameButton);
        row1.add(newsButton);
        add(row1);
        //adding second row
        JPanel row2 = new JPanel();
        mediaButton = new JButton("Blame");
        saveButton = new JButton("Save");
        dontSave = new JButton("No Save");
        FlowLayout flow2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        row2.setLayout(flow2);        
        row2.add(mediaButton);
        row2.add(saveButton);
        row2.add(dontSave);
        add(row2);       

        pack();
        setVisible(true);       
    }

    public static void main(String[] args) {
        MyFrame17 frame = new MyFrame17();
    }   
}