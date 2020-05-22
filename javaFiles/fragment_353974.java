import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AdderExample {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Demo");
                frame.getContentPane().setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                /* Use JFrameAdder if you want to add to a JFrame
                 * ---------------------------------------------- */
                JPanel panel = new JPanel();
                addButton(panel, new JPanelAdder(), "blah", 10, 10, 100, 10);
                frame.getContentPane().add(panel);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public static <T> JButton addButton(T app, Adder<T> adder, String text, int x, int y, int width, int height) {
        try {
            JButton button = new JButton();
            button.setText(text);
            button.setBounds(x, y, width, height);
            adder.add(button, app);
            System.out.println("\"" + text + "\" button created.");
            return button;
        }catch(Exception e) {
            System.out.println("Something went wrong when creating the \"" + text + "\" button.");
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
interface Adder<E>{
    void add(JButton btn, E e);
}

class JFrameAdder implements Adder<JFrame>{
    @Override
    public void add(JButton btn, JFrame e) {
        e.getContentPane().add(btn);
    }
}
class JPanelAdder implements Adder<JPanel>{
    @Override
    public void add(JButton btn, JPanel e) {
        e.add(btn);
    }
}