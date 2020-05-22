@Override
public void mouseClicked(MouseEvent e) {
    Component comp = e.getComponent();
    if (comp instanceof JToggleButton) {
        JToggleButton jtb = (JToggleButton)comp;
        jtb.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.white));
    }
}