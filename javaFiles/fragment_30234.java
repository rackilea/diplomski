import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class FileChoose {

    JFrame frame;

    public FileChoose() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar l = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Addvertex");

        open.addActionListener(new ActionListener() {
            Integer index;

            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pn = new JPanel();
                JTextField jt = new JTextField(5);
                JTextField jt1 = new JTextField(5);
                pn.add(jt);
                pn.add(jt1);
                int result = JOptionPane.showConfirmDialog(null, pn, "Enter the values", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    index = Integer.parseInt(jt.getText());
                    System.out.println(jt1.getText());
                }
                HelloHere(index.toString());
            }
        });

        JMenuItem close = new JMenuItem("Exit");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu tools = new JMenu("Tools");
        file.add(open);
        file.add(close);

        frame.setJMenuBar(l);
        l.add(tools);
        l.add(file);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void HelloHere(String p) {
        Draw d = new Draw(p);
        frame.add(d);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FileChoose f = new FileChoose();
            }
        });
    }
}

class Draw extends JPanel {

    String inp;

    public Draw(String gn) {
        inp = gn;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Random r = new Random();
        int x = r.nextInt(100);

        g2.drawOval(x, x * 2, 100, 100);
        g2.drawString(inp, x + (x / 2), x + (x / 2));
    }
}