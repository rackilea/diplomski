// class of mine to allow disposing of a window
// It's a little complex to allow it to work with either a JButton
// or a JMenuItem
@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
    public ExitAction() {
        super("Exit");
        putValue(MNEMONIC_KEY, KeyEvent.VK_X);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the button that caused this action
        Object source = e.getSource();
        Window topWindow = null;
        if (source instanceof AbstractButton) {
            AbstractButton exitButton = (AbstractButton) source;

            // get the parent top level window
            topWindow = SwingUtilities.getWindowAncestor(exitButton);
            if (topWindow == null) { // if null, then likely in a JMenuItem
                // so we have to get its jpopupmenu parent
                Container parent = exitButton.getParent();
                if (parent instanceof JPopupMenu) {
                    JPopupMenu popupMenu = (JPopupMenu) parent;

                    // get the invoker for the pop up menu
                    Component invoker = popupMenu.getInvoker();
                    if (invoker != null) {
                        // and get *its* top level window
                        topWindow = SwingUtilities.getWindowAncestor(invoker);
                    }
                }
            }
        } else if (source instanceof Component) {
            // if in key bindings
            topWindow = SwingUtilities.getWindowAncestor((Component) source);
        }
        if (topWindow != null) {
            // dispose of the top-level window
            topWindow.dispose();
        }
    }
}