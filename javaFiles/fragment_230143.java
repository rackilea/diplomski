import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Test extends JFrame {
    private JButton LeftButton;
    private JButton RightButton;
    private JScrollPane scroll;
    private JTextArea south;
    private MyActionListener MAL;

    public static void main(String[] args) {
        Test l = new Test("Aufgabe18c");
    }

    public Test(String title) {
        super(title);
        setSize(300, 150);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //initialize south
        south = new JTextArea(5, 20);
        south.setEditable(true);

        //pass it to your Listener
        MAL = new MyActionListener(south);
        JScrollPane scroll = new JScrollPane(south);
        this.add(scroll, BorderLayout.SOUTH);

        LeftButton = new JButton("Left Button");
        LeftButton.setOpaque(true);
        LeftButton.addActionListener(MAL);
        this.add(LeftButton, BorderLayout.WEST);

        RightButton = new JButton("Right Button");
        RightButton.setOpaque(true);
        RightButton.addActionListener(MAL);
        this.add(RightButton, BorderLayout.EAST);

        setVisible(true);
    }


public class MyActionListener implements ActionListener{

    private final JTextArea south;

    public MyActionListener(JTextArea south)
    {
        this.south = south;
    }

    private void setTextLeftButton(JTextArea south){
        south.append("Left Button \n");
    }

    private void setTextRightButton(JTextArea south){
        south.append("Right Button \n");
    }

@Override
        public void actionPerformed(ActionEvent e) {
        String a;
        Object src = e.getSource();
        JButton b = null;
        b = (JButton) src;
        a = b.getText();
        if (a == "Left Button")
            setTextLeftButton(south);
        else
            setTextRightButton(south);
    }
}
}