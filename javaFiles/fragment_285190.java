import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class drawing extends JPanel {
    public void draw(int x, int y) {
        p1.add(new ArrayList<Integer>());
        p1.get(p1.size()-1).add(x);
        p1.get(p1.size()-1).add(y);
        repaint();
    }
    public List<List<Integer>> p1 = new ArrayList<List<Integer>>(); 
    public List<List<Integer>> p2 = new ArrayList<List<Integer>>();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(List<Integer> u : p1) {
            g.setColor(new Color(0,0,255));
            g.fillRect(u.get(0)-1, u.get(1)-1, 3, 3);
        }
    }
}