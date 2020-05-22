import ij.gui.Toolbar;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Test1 {

    public static Toolbar tool;
    public static JFrame f;
    public static boolean state = false;

    public static void main(String[] args) {                
        f = new JFrame();
        f.setSize(600,600);
        Canvas c = new Canvas();
        f.add(c);

        tool = new Toolbar();
        Graphics g  = tool.getGraphics();
        tool.installStartupTools();

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem toolbar = new JMenuItem("Toolbar");
        menu.add(toolbar);
        menubar.add(menu);

        f.setJMenuBar(menubar);

        toolbar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                state = !state;
                tool.setVisible(state);
                tool.revalidate();
            }



        });

        tool.setVisible(false);
        f.add(tool);

        f.setVisible(true);
    }

}