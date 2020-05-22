import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test3 {

    public Test3() {

        JFrame frame = new JFrame("Exemple");
        JButton button1 = new JButton("Règles");
        button1.setBounds(100, 60, 100, 30);
        JButton button2 = new JButton("Jouer");
        JButton button3 = new JButton("Scores");
        JPanel pane1 = new JPanel(new GridLayout(0, 1));

        pane1.add(button1);
        pane1.add(button2);
        pane1.add(button3);
        frame.getContentPane().add(pane1, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Test3 test3 = new Test3();
            }
        });
    }

}