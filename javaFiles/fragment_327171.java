import java.awt.event.*;
import javax.swing.*;


public class QuickTest {

    public QuickTest(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                Timer t = new Timer(3000, null);
                t.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("test");
                        frame.dispose();

                    }
                });
                t.setRepeats(false);
                t.start();
            }
        });     
    }

    public static void main(String[] args){
        new QuickTest();
    }
}