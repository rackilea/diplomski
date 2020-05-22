public class Paint extends JPanel {
    private ArrayList<Brush> points;

    // . . .

    public void clear() {
        points.clear();
        repaint();
    }
}

public class Tools extends JPanel {
    private JButton clear;
    private Paint paint;

    public Tools(Paint paint) {
        this.paint = paint;
        // . . .
    }

    // . . .

    private class BrushInput implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clear) {
                paint.clear();
            }
        }
    }
}