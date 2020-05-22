import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ActionExample {

    public ActionExample() {

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.addMenuListener(new SampleMenuListener());
        JMenu menu1 = new JMenu("Tool");
        menu1.setMnemonic(KeyEvent.VK_T);
        menu1.addMenuListener(new SampleMenuListener());
        JFrame f = new JFrame("ActionExample");
        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        mb.add(menu1);
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ActionExample actionExample = new ActionExample();
            }
        });
    }
}

class SampleMenuListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("menuSelected");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        System.out.println("menuDeselected");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        System.out.println("menuCanceled");
    }
}