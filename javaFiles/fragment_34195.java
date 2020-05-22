import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JList<String> friends;

        public TestPane() {
            String names[] = {"Ana", "Banana", "Cikla", "Doris", "Ema", "Mirna", "Matea", "Veronika", "Vera", "Marta", "Mirta", "Davor", "Marko", "Matko", "Kloki"};
            JList<String> friends = new JList<String>(names);

            setLayout(new BorderLayout());
            add(new JScrollPane(friends));

            DisplayMessageDialog dmd = new DisplayMessageDialog();
            friends.addMouseListener(dmd);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

    }

    public class DisplayMessageDialog extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            JList theList = (JList) e.getSource();
            //              if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
            if (e.getClickCount() == 2) {
                int index = theList.locationToIndex(e.getPoint());
                if (index >= 0) {
                    Object o = theList.getModel().getElementAt(index);
                            //InstantMessageDialog imd = new InstantMessageDialog(null, o.toString());
                    //imd.setVisible(true);
                    JOptionPane.showMessageDialog(theList, "Double-clicked on: " + o.toString());
                    System.out.println("Double-clicked on: " + o.toString());
                }
            }
        }
    }
}