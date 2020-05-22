import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GUI extends JFrame implements ActionListener, PropertyChangeListener {

    private JPanel panel1, panel2, panel3;
//    private com.toedter.calendar.JCalendar calendar;
    private JPanel calendar;
    private JButton btn1, btn2;
    private JLabel label1, label2;

    public GUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        //panel1 components
        panel1 = new JPanel();
        btn1 = new JButton("Click me");
        panel1.add(btn1);

        //panel2 components
        panel2 = new JPanel();
        label1 = new JLabel("Time:");
        label2 = new JLabel("Date:");

        panel2.add(label1);
        panel2.add(label2);

        //JCalendar
        calendar = new JPanel();//new com.toedter.calendar.JCalendar();
        calendar.setBorder(new LineBorder(Color.RED));
        calendar.add(new JLabel("Calendar"));

        //panel3
        panel3 = new JPanel();
        panel3.setBorder(new LineBorder(Color.BLUE));
        panel3.add(new JLabel("Panel3"));

        panel2.setBorder(new LineBorder(Color.GREEN));

        //Add panels to JFrame
        add(panel1, BorderLayout.NORTH);
        add(calendar, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.EAST);

        //event handling
        btn1.addActionListener(this);

        //hide panel2
        panel2.setVisible(false);
        pack();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btn1)) {
            calendar.setVisible(false);
            panel3.setVisible(false);
            panel2.setVisible(true); //make panel2 visible
//            panel2.updateUI();
            revalidate();
            repaint();
        }
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}