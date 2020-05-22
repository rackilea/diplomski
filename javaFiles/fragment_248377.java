public class Main {

  public static final void addKeyBinding(JComponent c, String key, final Action action) {
    c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
    c.getActionMap().put(key, action);
    c.setFocusable(true);
  }

  public static void main(String[] args) {
    final JFrame frame = new JFrame("Fullscreen Toggle Test");

    Container contentPane = frame.getContentPane();
    contentPane.add(new JLabel("Toogle fullscreen using F11"), BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);

    addKeyBinding(frame.getRootPane(), "F11", new FullscreenToggleAction(frame));
  }
}