public class FitToScreenDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JComponent component = new JComponent() {};
        frame.add(component);
//      component.setPreferredSize(getDimensionWithoutTaskBar()); // 1
        frame.setPreferredSize(getDimensionWithoutTaskBar());     // 2
        frame.pack();
        frame.setVisible(true);
    }

    private static Dimension getDimensionWithoutTaskBar() {
        return new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
            (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight());
    }
}