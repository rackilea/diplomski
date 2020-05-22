public class JTreeFontResize {
    private static JTree tree;
    private static JFrame frame;

    public static void main(String[] args) throws InterruptedException,
            InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                tree = new JTree(new Object[] { "One (plain)",
                        "<html><u>Two (HTML)", "<html>Three (HTML)" });
                frame = new JFrame("Tree Font Resize");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 300, 300);
                frame.add(tree);
                frame.setVisible(true);
            }
        });

        Thread.sleep(2000);
        changeFontSize(20);

        Thread.sleep(2000);
        changeFontSize(30);

        Thread.sleep(2000);
        changeFontSize(12);
    }

    private static void changeFontSize(final int size) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Font font = new Font("Vernanda", Font.PLAIN, size);
                FontUIResource fontResource = new FontUIResource(font);
                Enumeration<Object> keys = UIManager.getDefaults().keys();
                while (keys.hasMoreElements()) {
                    Object key = keys.nextElement();
                    Object value = UIManager.get(key);
                    if (value instanceof FontUIResource) {
                        UIManager.put(key, fontResource);
                    }
                }
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
    }
}