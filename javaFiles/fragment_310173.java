import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Prosek extends JPanel {
    private static final int        yukseklik   = 140;
    private DropObject              koordinat;
    private List<DropObject>        objects     = new LinkedList<DropObject>();
    private LinkedList<TimerTask>   taskList    = new LinkedList<TimerTask>();

    public Prosek() {
        koordinat = new DropObject(yukseklik, 0, -20, 20);
        objects.add(koordinat);
        startSampling();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        for (DropObject o : objects) {
            Rectangle r = o.getObject();
            g2d.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    public void moveRectangle() {
        for (int i = (objects.size() - 1); i >= 0; i--) {
            DropObject o = objects.get(i);
            Rectangle r = o.getObject();
            if (o.getYukseklik() <= 140) {
                if (r.y < 140) {
                    r.y += r.height;
                    o.setObject(r);
                } else {
                    o.setYukseklik(o.getYukseklik() - r.height);
                    // stopSampling();
                }
            }
            if ((r.y >= 70) && (r.y <= 80)) {
                objects.add(new DropObject(yukseklik, 0, -20, 20));
            }
        }
    }

    void startSampling() {
        TimerTask task = new TimerTask() {
            public void run() {
                moveRectangle();
                repaint();

            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 500);
        taskList.add(task);

    }

    void stopSampling() {
        if (taskList.isEmpty()) {
            return;
        }
        taskList.removeFirst().cancel();

    }

}