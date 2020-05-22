public class ScreenCheck {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(-200, -200, 200, 200);
        Rectangle virtualBounds = getVirtualBounds();

        System.out.println(virtualBounds.contains(frame.getBounds()));

    }

    public static Rectangle getVirtualBounds() {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            bounds.add(gd.getDefaultConfiguration().getBounds());
        }
        return bounds;
    }
}