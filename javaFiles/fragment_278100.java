public  void hide(Component parent) {
    if (parent instanceof JFrame) {
        JFrame frame = (JFrame) parent;
        for (int i = 0; i < frame.getContentPane().getComponentCount(); i++) {
            Component comp = frame.getContentPane().getComponent(i);

            if (comp instanceof JButton) {
                comp.setVisible(false);
            } else {
                hide(comp);
            }
        }
    } else if (parent instanceof JPanel) {
        JPanel panel = (JPanel) parent;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Component comp = panel.getComponent(i);
            if (comp instanceof JButton) {
                comp.setVisible(false);
            } else {
                hide(comp);
            }
        }
    }
}