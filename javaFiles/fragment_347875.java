import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Histogram {

    private static final int BAR_WIDTH = 50;
    private static final int INCREMENT = 10;

    public Histogram() {
        final JTextArea textArea = new JTextArea(5, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JButton go = new JButton("Histogram-me!");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(go, BorderLayout.SOUTH);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                Map<Integer, Integer> counts = getCounts(text);
                int width = counts.size() * BAR_WIDTH;
                int max = maxCount(counts);
                int height = max * INCREMENT + 100;
                int horizon = height - 25;
                HistogramPanel panel = new HistogramPanel(width, counts, height, horizon);
                //panel.setBorder(new LineBorder(Color.BLACK, 2));
                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }

    private int maxCount(Map<Integer, Integer> counts) {
        int max = 0;
        for (Integer num : counts.values()) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public class HistogramPanel extends JPanel {

        int width;
        int dimHeight;
        int horizon;
        Map<Integer, Integer> counts;

        public HistogramPanel(int width, Map<Integer, Integer> counts, int dimHeight, int horizon) {
            this.width = width;
            this.counts = counts;
            this.dimHeight = dimHeight;
            this.horizon = horizon;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 10;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                int height = entry.getValue() * INCREMENT;
                int y = horizon - height;
                g.fillRect(x, y, BAR_WIDTH - 10, height);
                g.drawString(entry.getKey() + " chars", x, horizon + 10);
                g.drawString(entry.getValue() + " times", x, y -2);
                x += BAR_WIDTH;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, dimHeight);
        }
    }

    public static Map<Integer, Integer> getCounts(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] array = input.split("[\\s.,;:!?(){}]+");

        for (String s : array) {
            Integer size = s.length();
            if (!map.containsKey(size)) {
                map.put(size, 1);
            } else {
                map.put(size, map.get(size) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Histogram histogram = new Histogram();
            }
        });
    }
}