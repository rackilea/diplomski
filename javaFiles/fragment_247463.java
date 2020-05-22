import com.sun.java.swing.Painter;
import java.awt.*;
import javax.swing.*;

public class MyPopupWithNimbus {

    public MyPopupWithNimbus() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JList list = new JList();
        panel.add(list);
        frame.getContentPane().add(panel);
        JPopupMenu menu = new JPopupMenu();
        menu.add(new JMenuItem("A"));
        menu.add(new JMenuItem("B"));
        menu.add(new JMenuItem("C"));
        JMenu jmenu = new JMenu("D");
        jmenu.add(new JMenuItem("E"));
        menu.add(jmenu);
        frame.setVisible(true);
        menu.show(frame, 50, 50);
    }

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                    UIManager.getLookAndFeelDefaults().put("PopupMenu[Enabled].backgroundPainter",
                            new FillPainter(new Color(127, 255, 191)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyPopupWithNimbus aa = new MyPopupWithNimbus();
            }
        });
    }
}

class FillPainter implements Painter<JComponent> {

    private final Color color;

    FillPainter(Color c) {
        color = c;
    }

    @Override
    public void paint(Graphics2D g, JComponent object, int width, int height) {
        g.setColor(color);
        g.fillRect(0, 0, width - 1, height - 1);
    }
}