private static void recursiveUnfocusButtons(Component component) {
    if (component instanceof JButton) {
        component.setFocusable(false);
        return;
    } else if (component instanceof Container) {
        for (Component c : ((Container) component).getComponents()) {
            recursiveUnfocusButtons(c);
        }
    }
}