import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainFrame3 extends JFrame{

    public MainFrame3(){
        super("Symulator Lotow");

        JButton button = null;
        RelativeLayout layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        layout.setFill(true);
        JPanel returnPanel = new JPanel( layout );
        add(returnPanel);

        // top

        layout = new RelativeLayout(RelativeLayout.X_AXIS);
        layout.setFill(true);
        JPanel top = new JPanel( layout );
        returnPanel.add(top, new Float(6));

        button = new JButton();
        button.setBackground(Color.black);
        top.add(button, new Float(6));

        layout = new RelativeLayout(RelativeLayout.Y_AXIS);
        layout.setFill(true);
        JPanel topRight = new JPanel( layout );
        top.add(topRight, new Float(6));

        button = new JButton();
        button.setBackground(Color.white);
        topRight.add(button, new Float(4));

        layout = new RelativeLayout(RelativeLayout.X_AXIS);
        layout.setFill(true);
        JPanel rightBottom = new JPanel( layout );
        topRight.add(rightBottom, new Float(2));

        button = new JButton();
        button.setBackground(Color.blue);
        rightBottom.add(button, new Float(3));

        button = new JButton();
        button.setBackground(Color.blue);
        rightBottom.add(button, new Float(3));

        // middle

        layout = new RelativeLayout(RelativeLayout.X_AXIS);
        layout.setFill(true);
        JPanel middle = new JPanel( layout );
        returnPanel.add(middle, new Float(2));

        button = new JButton();
        button.setBackground(Color.yellow);
        middle.add(button, new Float(6));

        button = new JButton();
        button.setBackground(Color.yellow);
        middle.add(button, new Float(6));

        // bottom

        layout = new RelativeLayout(RelativeLayout.X_AXIS);
        layout.setFill(true);
        JPanel bottom = new JPanel( layout );
        returnPanel.add(bottom, new Float(2));

        button = new JButton();
        button.setBackground(Color.red);
        bottom.add(button, new Float(4));

        button = new JButton();
        button.setBackground(Color.red);
        bottom.add(button, new Float(4));

        button = new JButton();
        button.setBackground(Color.red);
        bottom.add(button, new Float(4));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MainFrame3();
    }
}