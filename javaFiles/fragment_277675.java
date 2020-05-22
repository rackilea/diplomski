import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class Div extends JFrame implements ActionListener{
    private JTextField green;
    private JTextField red;

    public static void main(String[] args) throws Exception{
        new Div();
    }

    public Div() throws Exception{
        UIManager.put("TextField.background", new ColorUIResource(Color.green));
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        green = new JTextField("Should be changed");
        red = new JTextField("Should not be changed");
        JPanel cp = (JPanel)getContentPane(); cp.setLayout(new GridLayout(2,1));
        cp.add(green);
        cp.add(red);
        red.setBackground(Color.red);
        green.addActionListener(this);
        setSize(200,100); setLocation(100,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color background = Color.YELLOW;
        UIManager.put("TextField.background", new ColorUIResource(background));
        SwingUtilities.updateComponentTreeUI(this);
    }
}