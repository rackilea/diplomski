import java.awt.BorderLayout;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class HashMapFrame {

    Map<String, MyInternalFrame> iFrames;
    String[] keys = {"TransportMaster", "AccountMaster", "BankMaster",
                     "GrandMaster", "WebMaster", "StackOverflowMaster"};
    JDesktopPane desktop;
    JButton button = new JButton("Add Frame");
    int index = 0;
    int x = 0;
    int y = 0;

    public HashMapFrame() {
        desktop = new JDesktopPane();
        iFrames = new HashMap<>();
        for (String s : keys) {
            iFrames.put(s, new MyInternalFrame(s, x, y));
            x += 30;
            y += 30;
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < 6) {
                    desktop.add(iFrames.get(keys[index]));
                    iFrames.get(keys[index]).setVisible(true);
                    try {
                        iFrames.get(keys[index]).setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(HashMapFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    index++;
                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(desktop);
        frame.add(button, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 550);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HashMapFrame();
            }
        });
    }
}

class MyInternalFrame extends JInternalFrame {

    public MyInternalFrame(String title, int x, int y) {
        super(title);

        setSize(300, 300);
        setLocation(x, y);
        setClosable(true);
    }
}