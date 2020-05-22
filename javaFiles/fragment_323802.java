private JMenuItem createMenuItem(final ImageIcon icon, String title) {
    JMenuItem item = new JMenuItem(title);
    item.setIcon(icon);

    ChangeListener cl = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() instanceof JMenuItem) {
                JMenuItem item = (JMenuItem) e.getSource();
                if (item.isSelected() || item.isArmed()) {
                    item.setIcon(stackIcon);
                } else {
                    item.setIcon(icon);
                }
            }
        }
    };
    item.addChangeListener(cl);

    return item;
}