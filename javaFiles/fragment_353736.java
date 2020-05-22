import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ShowData extends JLabel {
    int w, h;
    int hist[];
    int max_hist = 0;

    public ShowData(int[] histValue, int w, int h) {
        hist = new int[histValue.length];
        System.arraycopy(histValue, 0, hist, 0, histValue.length);
        this.w = w;
        this.h = h;
        setPreferredSize(new Dimension(w, h * 2));
        for (int i = 0; i < hist.length; i++) {
            if (hist[i] > max_hist) {
                max_hist = hist[i];
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = (w - hist.length) / 2;
        int lasty = h - h * hist[0] / max_hist;
        for (int i = 0; i < hist.length; i++, x++) {
            int y = h - h * hist[i] / max_hist;
            g.setColor(new Color(i, i, i));
            g.fillRect(x, y, 1, h);
            g.setColor(Color.red);
            g.drawLine(x - 1, lasty, x, y);
            lasty = y;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShowData data = new ShowData(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 100,
             100);
        frame.add(data);
        frame.pack();
        frame.setVisible(true);    
    }
}