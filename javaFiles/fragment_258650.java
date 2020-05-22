public class MyExtendedClass extends ... {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        double scaleFactor = 1d;
        // Calculate the scaling factor to apply
        // based on the "default" size and the
        // current size...
        g2d.scale(scaleFactor, scaleFactor);
        super.paint(g2d);
        g2d.dispose();
    }
}