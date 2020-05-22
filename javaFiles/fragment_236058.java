/**
 * Provides component hierarchy traversal.
 *
 * @param aContainer start node for the traversal.
 */
private void traverse(Container aContainer, JPopupMenu aMenu) {
    for (final Component comp : aContainer.getComponents()) {
        if (comp instanceof JComponent) {
            ((JComponent) comp).setComponentPopupMenu(aMenu);
        }
        if (comp instanceof Container) {
            traverse((Container) comp, aMenu);
        }
    }
}