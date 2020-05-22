import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;


public class Counter extends JPanel implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JWindow window = new JWindow();
                window.add(new Counter());
                window.pack();
                window.setLocationRelativeTo(null);
                window.setBackground(new Color(0, 0, 0, 0));
                window.setVisible(true);
            }
        });
    }

    private static final long serialVersionUID = 1L;
    private Timer timer;
    private int time;

    public Counter() {
        setOpaque(false);
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        System.out.println(time);
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.drawString(String.valueOf(time), getWidth() / 2, getHeight() / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time++;
        System.out.println("..." + time);
        repaint();
    }
}